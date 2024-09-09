FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
COPY target/wafacash.jar wafacash.jar
ENTRYPOINT ["java","-jar","/wafacash.jar"]