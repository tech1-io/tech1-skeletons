#!/usr/bin/env bash

set -x 

sudo apt-get update && \
	apt-get install -y apt-transport-https ca-certificates curl software-properties-common && \
	apt-get clean && \
	rm -rf /var/lib/apt/lists

curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -

sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu bionic stable"

sudo apt update

apt-cache policy docker-ce

sudo apt install -y docker-ce && \
	apt-get clean && \
	rm -rf /var/lib/apt/lists

docker ps

echo "Docker installation completed..."

