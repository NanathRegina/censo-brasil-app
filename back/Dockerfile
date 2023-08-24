FROM maven:3.6.0-jdk-8-alpine

WORKDIR /src
COPY ./ /src

RUN rm -rf ./back/target
RUN mvn clean package
RUN ls -lah
RUN cp -a /src/target/*.jar ./app.jar
RUN ls -lah
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","./app.jar"]