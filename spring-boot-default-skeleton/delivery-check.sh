#!/usr/bin/env bash

# Check SonarQube is running
SONAR_STATUS=$(sonar.sh status)
SUCCESS_OUTPUT="------------------------------------------------------------------------------
DELIVERY CHECK EXECUTION SUCCESS
------------------------------------------------------------------------------"
ERROR_OUTPUT="------------------------------------------------------------------------------
DELIVERY CHECK EXECUTION FAILURE
------------------------------------------------------------------------------"

if [[ $SONAR_STATUS == *"SonarQube is running"* ]]; then
    # Run tests and generate jacoco coverage report
    mvn clean test jacoco:report
    # Run SonarScanner
    sonar-runner -X
    if [ "$?" -ne "0" ]; then
        echo "$ERROR_OUTPUT"
    else
        echo "$SUCCESS_OUTPUT"
    fi
else
    echo "------------------------------------------------------------------------------"
    echo "$SONAR_STATUS"
    echo "------------------------------------------------------------------------------"
    echo "$ERROR_OUTPUT"
fi