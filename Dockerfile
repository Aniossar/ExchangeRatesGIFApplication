FROM adoptopenjdk/openjdk11:alpine-jre
RUN mkdir -p /usr/app
WORKDIR /usr/app
COPY ${JAR_FILE} /exchange-rates.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","exchange-rates.jar"]