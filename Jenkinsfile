pipeline {
    agent any
    options {
        buildDiscarder(logRotator(numToKeepStr:'5'))
    }
    triggers {
        pollSCM('H */1 * * *')
    }
    stages {
        stage('check') {
            steps {
                sh 'echo checking...'
            }
        }
    }
    post {
        always {
            script {
                // https://issues.jenkins-ci.org/browse/JENKINS-46325
                // https://jenkins.io/doc/book/pipeline/jenkinsfile/
                // Workaround: ['SUCCESS'] isEqualTo [null]
                if (currentBuild.result == null) {
                    currentBuild.result = 'SUCCESS'
                }
            }
            alwaysNotifications()
        }
        failure {
            failureNotifications()
        }
    }
}

def alwaysNotifications() {
    emailext (
        to: "$FORCELATE_CTO, $FORCELATE_DEVELOPERS",
        subject: '${DEFAULT_SUBJECT}',
        body: '''${SCRIPT, template="pipeline-changes.template"}'''
    )
}

def failureNotifications() {
    emailext (
        to: "$FORCELATE_ADMINISTRATORS",
        subject: '${DEFAULT_SUBJECT}',
        body: '''${SCRIPT, template="pipeline-changes.template"}'''
    )
}