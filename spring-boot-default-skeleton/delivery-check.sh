#!/usr/bin/env bash

# Check SonarQube is running
SONAR_STATUS=$(lsof -i :9000)
SUCCESS_OUTPUT="------------------------------------------------------------------------------
Delivery check execution: SUCCESS
------------------------------------------------------------------------------"
ERROR_OUTPUT="------------------------------------------------------------------------------
Delivery check execution: FAILURE
------------------------------------------------------------------------------"

if [ -z "$SONAR_STATUS" ]; then
    echo "$ERROR_OUTPUT"
else
    # Run install
    mvn clean install
    # Run sonar scanner
    sonar-runner -X
    if [ "$?" -ne "0" ]; then
        echo "$ERROR_OUTPUT"
    else
        echo "$SUCCESS_OUTPUT"
    fi
fi