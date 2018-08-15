#!/usr/bin/env bash

COMPANY=forcelate
APP=vuejs-nginx
TAG=dev

docker build -t ${COMPANY}/${APP}:${TAG} .
