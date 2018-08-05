#!/usr/bin/env bash
docker run -it -p 8787:8080 \
  -e VUEJS_PROFILE='dev' \
  --rm --name app-client forcelate/vuejs-http-server
