#!/usr/bin/env bash

# Remote: stop service
systemctl stop app.service

# Remote: cleanup
cd /root
rm -rf spring-boot
