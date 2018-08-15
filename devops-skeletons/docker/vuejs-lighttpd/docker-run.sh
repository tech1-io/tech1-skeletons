#!/usr/bin/env bash

COMPANY=forcelate
APP=vuejs-lighttpd
TAG=dev

docker run -it -p 8787:80 --rm --name ${APP} ${COMPANY}/${APP}:${TAG}
