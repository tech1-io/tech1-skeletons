#!/usr/bin/env bash

# Remote: copy resources
systemctl restart lighttpd.service

# Remote: cleanup
cd /root
rm -rf frontend
