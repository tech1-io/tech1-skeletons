#!/usr/bin/env bash
mvn clean install
docker build -t forcelate/spring-boot:dev .
