#!/usr/bin/env bash

COMPANY=forcelate
APP=spring-boot-server
TAG=dev
SPRING_BOOT_PROFILE=$1
JASYPT_ENCRYPTOR_PASSWORD=$2
echo "==============================================================="
echo "ENV: -Dspring.profiles.active = '$SPRING_BOOT_PROFILE'"
echo "ENV: -Djasypt.encryptor.password = '$JASYPT_ENCRYPTOR_PASSWORD'"
echo "==============================================================="

if [ "$SPRING_BOOT_PROFILE" != "dev" ] &&
    [ "$SPRING_BOOT_PROFILE" != "preprod" ] &&
    [ "$SPRING_BOOT_PROFILE" != "prod" ]; then

    echo "Available profiles: { dev | preprod | prod }"
    echo "Docker run: Failed. Exit (1)"
    exit 1

fi

docker run -it -p 8484:8484 \
  -e SPRING_BOOT_PROFILE=${SPRING_BOOT_PROFILE} \
  -e JASYPT_ENCRYPTOR_PASSWORD=${JASYPT_ENCRYPTOR_PASSWORD} \
  --rm --name ${APP} ${COMPANY}/${APP}:${TAG}
