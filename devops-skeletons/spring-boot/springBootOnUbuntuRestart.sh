#!/usr/bin/env bash

# Remote: restart service
systemctl restart app.service

# Remote: cleanup
cd /root
rm -rf spring-boot
