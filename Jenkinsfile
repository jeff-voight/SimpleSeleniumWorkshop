pipeline {
    agent any
    stages {
        stage('Build'){
            agent {
                docker {
                    image 'maven:3-alpine'
                }
            }
            steps {
                sh 'mkdir -p repo'
                sh 'cp -r ${WORKSPACE}/* repo'
                sh 'cd repo'
                sh 'mvn package'
            }
        }
    }
}