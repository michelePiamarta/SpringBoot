FROM openjdk:17-oracle
COPY target/*.jar backend.jar
EXPOSE 8080
ENTRYPOINT [ "java"; "-jar"; "backend.jar" ]