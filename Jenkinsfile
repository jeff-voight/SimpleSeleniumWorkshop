pipeline {
    agent {
        label 'java'
    }
    stages {
        stage('Build'){
            steps {
                sh 'mkdir -p /tmp/repo'
                sh 'cp -r ${WORKSPACE}/* /tmp/repo'
                sh 'cd /tmp/repo'
                sh 'package'
            }
        }
    }
}