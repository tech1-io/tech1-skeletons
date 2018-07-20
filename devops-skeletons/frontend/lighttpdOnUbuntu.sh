#!/usr/bin/env bash

# Remote: lighttpd
apt-get update && \
apt-get install -y lighttpd && \
apt-get clean 

# Remote: Override server configuration
cp /root/frontend/lighttpd.conf /etc/lighttpd/lighttpd.conf

# Remote: Cleanup
cd /root
rm -rf frontend
