#!/usr/bin/env bash

# Remote: stop service
systemctl stop app.service

# Remote: prepare JAR
cp /root/preparation/app.jar /root/app/app.jar
chmod +x /root/app/app.jar

# Remote: start service
systemctl start app.service

# Remote: Cleanup
cd /root
rm -rf spring-boot
