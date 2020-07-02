podTemplate(label: 'maven', containers: [
        containerTemplate(name: 'maven', image: 'maven:3.6.3-jdk-8', ttyEnabled: true, command: 'cat')
]) {
    node('maven') {
        stage('Build') {
            container('maven') {
                stage("git clone") {
                    sh 'git clone --branch master --depth=1 https://github.com/jvoight0205/SimpleSeleniumWorkshop.git .'
                }
                stage('Build maven project') {
                    withCredentials([string(credentialsId: 'sonartoken', variable: 'SONAR_LOGIN'), string(credentialsId: 'sonarhost', variable: 'SONAR_HOST')]) {
                        sh ("mvn verify sonar:sonar -Dsonar.host=$SONAR_HOST -Dsonar.login=$SONAR_LOGIN")
                    }
                }
            }
        }
    }
}