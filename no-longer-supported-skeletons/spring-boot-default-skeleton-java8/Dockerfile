FROM openjdk:8-jdk-alpine
WORKDIR /app
EXPOSE 8484
ADD /target/app.jar app.jar
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-Dspring.profiles.active=${SPRING_BOOT_PROFILE}", "-Djasypt.encryptor.password=${JASYPT_ENCRYPTOR_PASSWORD}", "-jar", "app.jar"]
