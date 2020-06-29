pipeline {
    agent any
    stages {
        stage('Build'){
            agent any
            steps {
                sh 'mkdir -p /tmp/repo'
                sh 'cp -r ${WORKSPACE}/* /tmp/repo'
                sh 'cd /tmp/repo'
                sh 'mvn package'
            }
        }
    }
}