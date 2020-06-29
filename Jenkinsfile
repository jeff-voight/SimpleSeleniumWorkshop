pipeline {
    agent any
    stages {
        stage('Build'){
            steps {
                sh 'mkdir -p /tmp/repo'
                sh 'cp -r ${WORKSPACE}/* /tmp/repo'
                sh 'cd /tmp/repo'
                sh '/usr/bin/mvn package'
            }
        }
    }
}