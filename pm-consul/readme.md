# Microservices With Spring Cloud Consul Demo Project [![Twitter](https://img.shields.io/twitter/follow/piotr_minkowski.svg?style=social&logo=twitter&label=Follow%20Me)](https://twitter.com/piotr_minkowski)

[![CircleCI](https://circleci.com/gh/piomin/sample-spring-cloud-consul.svg?style=svg)](https://circleci.com/gh/piomin/sample-spring-cloud-consul)

[![SonarCloud](https://sonarcloud.io/images/project_badges/sonarcloud-black.svg)](https://sonarcloud.io/dashboard?id=piomin_sample-spring-cloud-consul)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=piomin_sample-spring-cloud-consul&metric=bugs)](https://sonarcloud.io/dashboard?id=piomin_sample-spring-cloud-consul)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=piomin_sample-spring-cloud-consul&metric=coverage)](https://sonarcloud.io/dashboard?id=piomin_sample-spring-cloud-consul)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=piomin_sample-spring-cloud-consul&metric=ncloc)](https://sonarcloud.io/dashboard?id=piomin_sample-spring-cloud-consul)

In this project I'm demonstrating you how to use Hashicorp's **Consul** as a discovery and configuration server with [Spring Cloud Consul](https://spring.io/projects/spring-cloud-consul) and other Spring Cloud projects for building microservice-based architecture.

## Getting Started
1. To build and run sample applications you need to have Maven, JDK11+ and Docker. However, the simplest way to start with it is through any IDE like Intellij or Eclipse.
2. First, you have to run Consul on Docker container
```
$ docker run -d --name consul-1 -p 8500:8500 -e CONSUL_BIND_INTERFACE=eth0 consul
```
3. Then you can compile your application with Maven `mvn clean install` command and using `java -jar ...` command. Or you can just build it and run using your IDE. Each application is listeting on dynamically generated port.

## Architecture
Our sample microservices-based system consists of the following modules:
- **gateway-service** - a module that uses Spring Cloud Gateway for running Spring Boot application that acts as a proxy/gateway in our architecture.
- **account-service** -  a module containing the first of our sample microservices that allows to perform CRUD operation on in-memory repository of accounts
- **customer-service** - a module containing the second of our sample microservices that allows to perform CRUD operation on in-memory repository of customers. It communicates with account-service.
- **product-service** - a module containing the third of our sample microservices that allows to perform CRUD operation on in-memory repository of products.
- **order-service** - a module containing the fourth of our sample microservices that allows to perform CRUD operation on in-memory repository of orders. It communicates with all other microservices.

The following picture illustrates the architecture described above.

<img src="https://piotrminkowski.files.wordpress.com/2019/11/microservices-consul-1-1.png" title="Architecture"><br/>

When running sample applications we can test more advanced scenario. We may leverage **Zone Affinity** mechanism to prefer communication inside a single zone. We can also start a cluster of Consul modes started locally on Docker containers. Here's the picture illustrating such an architecture:

<img src="https://piotrminkowski.files.wordpress.com/2019/11/microservices-consul-2.png" title="Architecture"><br/>

## Description
Detailed description can be found here: [Microservices with Spring Boot, Spring Cloud Gateway and Consul Cluster](https://piotrminkowski.com/2019/11/06/microservices-with-spring-boot-spring-cloud-gateway-and-consul-cluster/)


## Interventi [Y]

1. Occorre rimuovere, per i logger, gli appender STASH - che punta ad un servizio - e, se necessario, FILE.
2. Rimossi progressivamente i riferimenti al multizone

### Web Content Serving

Una risorsa statica (come `/resources/static/index.html`) viene servita [direttamente](https://www.baeldung.com/spring-webflux-static-content) `http://localhost:8080/static/index.html` senza alcuna necessità di configurazione, né nelle routes di application.yml né con una classe di WebFluxConfigurer né, infine, come indicazione di `webflux.static-path-pattern`.

Anzi l'utilizzo di routes come quella riportata di seguito:

```yml
      routes:
        - id: static
          uri: classpath:/static/**
          predicates:
            - Path=/portal/**
```

Porta al serving di una pagina vuota (ma senza errore)



L'utilizzo di una classe WebFluxConfigurer consente di utilizzare anche folder diversi da cui servire. 



In particolare, se si vuole mappare su un folder `/webs` che può essere inserito a mano in `target/classes` si può configurare una classe simile:

```java
@Configuration
@EnableWebFlux
public class WebConfig implements WebFluxConfigurer {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebConfig.class);

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        LOGGER.info("-->>> addResourceHandlers");
        registry.addResourceHandler("/web/**")
                .addResourceLocations("classpath:/webs/"); 
        registry.addResourceHandler("/assets/**")
                .addResourceLocations("classpath:/webs/assets/");
    }
}
```



Tutte le risorse con `/web` vengono prelevate da `classpath:/webs`. Nel caso di risorse con folder ulteriori, come nel caso di un'applicazione react, tutti i folder devono essere opportunamente mappati.

Il folder `/webs` è in `/src/webs` di gateway e va copiato manualmente in `/target/classes` per poter funzionare correttamente.



### Scaling

Lo [scaling](https://thelinuxcode.com/scale-services-in-docker-compose/) ipotizzato è basato su *docker compose*. Ogni microservizio è un container, incluso il gateway, e tutti fanno riferimento a consul e keycloak.

Compose Scaling

Per lanciare più copie di un servizio è sufficiente un comando come il seguente:

```bash
docker compose -f <compose_file> up --scale <SERVICE>=<INSTANCES>
```

In alternativa si può usare

```bash
docker compose -f <compose_file> scale <SERVICE>=<INSTANCE>
```



#### Consul e Container

Visto che Consul è gestito con container, affinché un microservizio - dal proprio container - possa raggiungerlo non deve usare localhost ma il nome del servizio così come ricavato dal compose.

Il segmento di configurazione, in application.yml, è il seguente:

```yml
spring:  
  application:
    name: customer-service
  cloud:
    consul:
      host: ${CONSUL_HOST:localhost}
      port: ${CONSUL_PORT:8500}
      discovery:
        instance-id: ${spring.application.name}:${random.uuid}
  config:
    import: optional:consul:${CONSUL_HOST:localhost}:${CONSUL_PORT:8500}
```



Nel file di _compose_  deve essere configurato il corretto environment. Ad esemio:

```yml
  customer:
    image: pm-consul/customer-service
    environment:
      - CONSUL_HOST=consul-dev
      - CONSUL_URL=consul-dev
      - CONSUL_PORT=8500
    ports:
      - "10200-10250:10200"
    depends_on:
      - consul-dev
```



#### Dynamic Port

Per poter specificare un range di porte in cui ricadranno le copie di scaling, è necessario una specifica come la seguente:

```yml
    ports:
      - "10200-10250:10200"    
```



