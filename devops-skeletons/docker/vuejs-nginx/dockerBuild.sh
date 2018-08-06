#!/usr/bin/env bash

VUEJS_PROFILE=$1
echo "===================================="
echo "ARG: vue.js profile = $VUEJS_PROFILE"
echo "===================================="

if [ "$VUEJS_PROFILE" != "dev" ] &&
    [ "$VUEJS_PROFILE" != "preprod" ] &&
    [ "$VUEJS_PROFILE" != "prod" ]; then

    echo "Available profiles: { dev | preprod | prod }"
    echo "Docker run: Failed. Exit (1)"
    exit 1

fi

docker build \
  --build-arg VUEJS_PROFILE=${VUEJS_PROFILE} \
  -t forcelate/vuejs-nginx .
