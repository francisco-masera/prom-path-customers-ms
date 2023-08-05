FROM azul/zulu-openjdk-alpine:11.0.20

WORKDIR /app

COPY ./build/libs/customers-ms-0.0.1-SNAPSHOT.jar .

EXPOSE 9001

ADD ./build/libs/customers-ms-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
