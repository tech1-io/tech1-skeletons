#!/usr/bin/env bash

APP=spring-boot-server

if [ "$(docker ps -q -f name=${APP})" ]; then docker kill ${APP}; else echo "Container ${APP} is missing"; fi
docker rm ${APP}
