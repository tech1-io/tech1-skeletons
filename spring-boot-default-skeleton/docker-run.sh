#!/usr/bin/env bash

COMPANY=forcelate
APP=spring-boot-server
TAG=dev
SPRING_BOOT_PROFILE=$1
echo "===================================================="
echo "ENV: -Dspring.profiles.active = $SPRING_BOOT_PROFILE"
echo "===================================================="

if [ "$SPRING_BOOT_PROFILE" != "dev" ] &&
    [ "$SPRING_BOOT_PROFILE" != "preprod" ] &&
    [ "$SPRING_BOOT_PROFILE" != "prod" ]; then

    echo "Available profiles: { dev | preprod | prod }"
    echo "Docker run: Failed. Exit (1)"
    exit 1

fi

docker run -it -p 8484:8484 \
  -e SPRING_BOOT_PROFILE=${SPRING_BOOT_PROFILE} \
  --rm --name ${APP} ${COMPANY}/${APP}:${TAG}
