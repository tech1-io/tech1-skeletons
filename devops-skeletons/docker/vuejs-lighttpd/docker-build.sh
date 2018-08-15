#!/usr/bin/env bash

COMPANY=forcelate
APP=vuejs-lighttpd
TAG=dev

docker build -t ${COMPANY}/${APP}:${TAG} .
