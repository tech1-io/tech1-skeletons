#!/usr/bin/env bash

COMPANY=forcelate
APP=vuejs-nginx
TAG=latest

docker stop ${APP}

docker pull ${COMPANY}/${APP}:${TAG}

docker run -d -it -p 8484:8484 \
  -e SPRING_BOOT_PROFILE=${SPRING_BOOT_PROFILE} \
  --rm --name ${APP} ${COMPANY}/${APP}:${TAG}
