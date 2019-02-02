#!/usr/bin/env bash

COMPANY=forcelate
APP=spring-boot-server
TAG=latest

if [ "$(docker ps -q -f name=${APP})" ]; then docker kill ${APP}; else echo "Container ${APP} is missing"; fi
