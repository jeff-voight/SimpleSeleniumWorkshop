podTemplate(label: 'maven', containers: [
        containerTemplate(name: 'maven', image: 'maven:3.6.3-jdk-8', ttyEnabled: true, command: 'cat')
]) {
    node('maven') {
        stage('Build') {
            container('maven') {
                stage("git clone") {
                    sh 'git clone --branch master -depth=1 https://github.com/jvoight0205/SimpleSeleniumWorkshop.git .'
                }
                stage('Build maven project') {
                    sh 'mvn package'
                }
            }
        }
    }
}