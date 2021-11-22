FROM openjdk:16-alpine

RUN apk add --no-cache bash

WORKDIR /runetopic-http-server

EXPOSE 80:8080

CMD ./gradlew run