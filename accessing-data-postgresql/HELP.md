# Commits and Progress

1. Esempio per come costruito a partire dalla guida su spring.io e adattata a postgresql.
2. Inserire i dati di preload con un componente apposta (da programma, quindi)
3. Inserire i dati di preload semplicemente con un file SQL in resource (Attenzione, qui 
   probabilmente serve ID se non è settata una sequence)
4. Introduzione di Lombok + Introduzione utilizzo Sequence in Postgresql. Attenzione ai vari 
   problemi (quoting, sequence in create or sequence in update, ... ). Citare anche 
   https://medium.com/vena-engineering/the-inheritance-hashset-related-bug-with-lombok-36dbcfb04381 
5. 



# Read Me First
The following was discovered as part of building this project:

* The original package name 'com.example.accessing-data-postgresql' is invalid and this project uses 'com.example.accessingdatapostgresql' instead.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.2/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.2/reference/htmlsinge/index.html#web)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.1.2/reference/htmlsinge/index.html#data.sql.jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

