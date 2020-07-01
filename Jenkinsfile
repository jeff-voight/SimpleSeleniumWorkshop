podTemplate(label: 'maven', containers: [
        containerTemplate(name: 'maven', image: 'maven:3.6.3-jdk-8', ttyEnabled: true, command: 'cat')
]) {
    node('maven') {
        stage('Build') {
            container('maven') {
                stage("git clone") {
                    sh 'mkdir -p /tmp/repo'
                    sh 'cd /tmp/repo'
                    sh 'git clone https://github.com/jvoight0205/SimpleSeleniumWorkshop.git/'
                    sh 'cd SimpleSeleniumWorkshop'
                }
                stage('Build maven project') {
                    sh 'mvn package'
                }
            }
        }
    }
}