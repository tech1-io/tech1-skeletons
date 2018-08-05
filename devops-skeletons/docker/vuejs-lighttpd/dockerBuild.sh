#!/usr/bin/env bash
docker build \
  --build-arg VUEJS_PROFILE='dev' \
  -t forcelate/vuejs-lighttpd.
