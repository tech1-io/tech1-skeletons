#!/usr/bin/env bash

# Remote: lighttpd
apt-get update
apt-get upgrade 
apt-get install -y lighttpd

# Remote: Cleanup
cd /root
rm -rf frontend
