#!/usr/bin/env bash

# Remote: support components
sudo apt-get update && \
sudo apt-get install -y software-properties-common && \
sudo apt-get clean && \
sudo rm -rf /var/lib/apt/lists

# Remote: Java8
sudo echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | sudo debconf-set-selections && \
sudo add-apt-repository -y ppa:webupd8team/java && \
sudo apt-get update && \
sudo apt-get install -y oracle-java8-installer && \
sudo rm -rf /var/lib/apt/lists/* && \
sudo rm -rf /var/cache/oracle-jdk8-installer

# Remote: Folders
mkdir /root/preparation
mkdir /root/app

