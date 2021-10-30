#!/usr/bin/env bash

COMPANY=forcelate
APP=spring-boot-server
TAG=$1
DOCKERHUB_USERNAME=$2
DOCKERHUB_PASSWORD=$3
echo "===================================="
echo "Docker Tag = $TAG"
echo "===================================="

if [ "$TAG" != "dev" ] &&
    [ "$TAG" != "latest" ]; then

    echo "Available tags: { dev | latest }"
    echo "Docker push: Failed. Exit (1)"
    exit 1

fi

echo "Docker push: started..."

echo "Docker build image"
docker build -t ${COMPANY}/${APP}:${TAG} .

echo "Docker tag image"
docker tag ${COMPANY}/${APP}:${TAG} ${COMPANY}/${APP}:${TAG}

echo "Docker push image"
docker login -u ${DOCKERHUB_USERNAME} -p ${DOCKERHUB_PASSWORD}
docker push ${COMPANY}/${APP}:${TAG}

echo "Docker delete images"
docker rmi -f $(docker images | grep ${APP})

echo "Docker push: completed..."
