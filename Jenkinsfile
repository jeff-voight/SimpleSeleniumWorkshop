podTemplate(label: 'maven', containers: [
        containerTemplate(name: 'maven', image: 'maven:3.6.3-jdk-8', ttyEnabled: true, command: 'cat')
]) {
    node('maven') {
        stage('Build') {
            container('maven') {
                stage('Build maven project') {
                    sh 'mkdir -p /tmp/repo'
                    sh 'cp -r ${WORKSPACE}/* /tmp/repo'
                    sh 'cd /tmp/repo'
                    sh 'mvn package'
                }
            }
        }
    }
}