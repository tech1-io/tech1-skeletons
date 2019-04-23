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

# OPTIONAL
# ========================================================================

# AWS: sudo docker ps => docker ps
# URL: https://docs.docker.com/install/linux/linux-postinstall/

sudo usermod -aG docker $USER

# Log out and log back in so that your group membership is re-evaluated

# WARNING: Error loading config file: /home/user/.docker/config.json
# stat /home/user/.docker/config.json: permission denied

sudo chown "$USER":"$USER" /home/"$USER"/.docker -R
sudo chmod g+rwx "$HOME/.docker" -R

# ========================================================================

echo "Docker installation completed..."

