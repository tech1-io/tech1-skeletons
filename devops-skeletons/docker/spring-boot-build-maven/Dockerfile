# build-stage
FROM anapsix/alpine-java:8_jdk as build-stage
WORKDIR /build
ENV MAVEN_VERSION 3.5.3
ENV MAVEN_HOME /usr/lib/mvn
ENV PATH $MAVEN_HOME/bin:$PATH
RUN wget http://archive.apache.org/dist/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz && \
  tar -zxvf apache-maven-$MAVEN_VERSION-bin.tar.gz && \
  rm apache-maven-$MAVEN_VERSION-bin.tar.gz && \
  mv apache-maven-$MAVEN_VERSION /usr/lib/mvn
COPY . .
RUN mvn clean -DskipTests=true install

# production stage
FROM anapsix/alpine-java:8 as production-stage
EXPOSE 8484
COPY --from=build-stage /build/target/app.jar app.jar
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-Dspring.profiles.active=dev", "-jar", "app.jar"]
