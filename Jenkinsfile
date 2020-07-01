podTemplate(containers: [
        containerTemplate(name: 'maven', image: 'maven:3.6.3-jdk-8', ttyEnabled: true, command: 'cat')
]) {
    node() {
        stage('Build') {
            container('maven') {
                stage {
                    sh 'mkdir -p /tmp/repo'
                    sh 'cp -r ${WORKSPACE}/* /tmp/repo'
                    sh 'cd /tmp/repo'
                    sh 'mvn package'
                }
            }
        }
    }
}