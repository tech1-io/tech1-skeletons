#!/usr/bin/env bash

# Cleanup generated files
rm -rf .idea
rm -rf .sonar
rm -rf target
find . -name '*.iml' -delete