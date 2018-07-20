#!/usr/bin/env bash

# Remote: copy resources
systemctl stop lighttpd.service

# Remote: cleanup
cd /root
rm -rf frontend
