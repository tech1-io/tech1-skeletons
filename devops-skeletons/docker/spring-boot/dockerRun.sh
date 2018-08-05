#!/usr/bin/env bash
docker run -it -p 8484:8484 \
-e SPRING_BOOT_PROFILE='dev' \
--rm --name app-server forcelate/spring-boot
