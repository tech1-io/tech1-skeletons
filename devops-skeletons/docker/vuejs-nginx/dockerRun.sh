#!/usr/bin/env bash
docker run -it -p 8787:80 \
  -e VUEJS_PROFILE='dev' \
  --rm --name app-client forcelate/vuejs-nginx
