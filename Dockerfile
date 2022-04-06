FROM eclipse-temurin:17-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ARG JASYPT_PASS
ENV JASYPT_PASS=$JASYPT_PASS
ENTRYPOINT ["java", "-jar", "/app.jar", "--jasypt.encryptor.password=${JASYPT_PASS}"]
