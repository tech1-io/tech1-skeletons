#!/usr/bin/env bash

# Remote: copy resources
rm -rf /var/www/html/*
cp -r /root/preparation/dist/* /var/www/html

# Remote: cleanup
cd /root
rm -rf frontend
