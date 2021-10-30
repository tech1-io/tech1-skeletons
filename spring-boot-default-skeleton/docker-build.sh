#!/usr/bin/env bash

COMPANY=tech1
APP=spring-boot-server
TAG=dev

mvn clean install
docker build -t ${COMPANY}/${APP}:${TAG} .
