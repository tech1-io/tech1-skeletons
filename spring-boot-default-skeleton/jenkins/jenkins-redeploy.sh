#!/usr/bin/env bash

COMPANY=forcelate
APP=spring-boot-server
TAG=latest
SPRING_BOOT_PROFILE=prod

if [ "$(docker ps -q -f name=${APP})" ]; then docker kill ${APP}; else echo "Container ${APP} is missing"; fi

docker pull ${COMPANY}/${APP}:${TAG}

docker run -d -it -p 8484:8484 \
	-v /root/app/logs:/root/app/logs \
 	-e SPRING_BOOT_PROFILE=${SPRING_BOOT_PROFILE} \
  	--rm --name ${APP} ${COMPANY}/${APP}:${TAG}
