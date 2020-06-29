pipeline {
    agent any
    stages {
        stage('Build'){
            agent any
            steps {
                sh 'mkdir -p repo'
                sh 'cp -r ${WORKSPACE}/* repo'
                sh 'cd repo'
                sh 'mvn package'
            }
        }
    }
}