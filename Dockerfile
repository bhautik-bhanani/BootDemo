FROM openjdk:8-jdk-alpine
EXPOSE 8086
ADD target/BootDemo-0.0.1-SNAPSHOT.jar bootDemo.jar
ENTRYPOINT ["java", "-jar", "bootDemo.jar"]
