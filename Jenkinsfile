podTemplate(containers: [
        containerTemplate(name: 'maven:3.6.3-java-8', ttyEnabled: true, command: 'cat')
]) {
    node(POD_LABEL) {
        stage('Build') {
            steps {
                sh 'mkdir -p /tmp/repo'
                sh 'cp -r ${WORKSPACE}/* /tmp/repo'
                sh 'cd /tmp/repo'
                sh 'mvn package'
            }
        }
    }
}