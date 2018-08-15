#!/usr/bin/env bash

COMPANY=forcelate
APP=vuejs-http-server
TAG=dev

docker run -it -p 8787:8080 --rm --name ${APP} ${COMPANY}/${APP}:${TAG}
