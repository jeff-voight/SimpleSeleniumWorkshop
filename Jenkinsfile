pipeline {
    agent {
        docker {
            image 'maven:3.6.3-java-8'
        }
    }
    stages {
        stage('Build'){
            steps {
                sh 'mkdir -p /tmp/repo'
                sh 'cp -r ${WORKSPACE}/* /tmp/repo'
                sh 'cd /tmp/repo'
                sh 'mvn package'
            }
        }
    }
}