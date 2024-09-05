FROM registry.access.redhat.com/ubi9/openjdk-21:1.20-2.1721752936

#ENV SPRING_OUTPUT_ANSI_ENABLED=NEVER \
#    JAVA_DEFAULT_OPTS="-Dnetworkaddress.cache.ttl=60 \
#    -Djava.security.egd=file:/dev/./urandom \
#    -Dsun.misc.URLClassPath.disableJarChecking=true" \
#    JAVA_OPTS="" \
#    JAVA_ARGS="--spring.profiles.active=docker"
#
#ADD target/*.jar /opt/kwhale/app.jar
#
#USER 1000
#
#CMD /usr/bin/java ${JAVA_DEFAULT_OPTS} ${JAVA_OPTS} -jar  /opt/kwhale/app.jar ${JAVA_ARGS}
USER root
#RUN ls -la && echo "hello"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
#RUN ls -la && echo "hello 2"
#RUN java -jar app.jar && echo "hello 3"
ENTRYPOINT ["java","-jar","app.jar"]