#!/usr/bin/env bash

COMPANY=forcelate
APP=vuejs-http-server
TAG=dev

docker build -t ${COMPANY}/${APP}:${TAG} .
