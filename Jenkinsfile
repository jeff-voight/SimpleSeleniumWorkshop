podTemplate(label: 'maven', containers: [
        containerTemplate(name: 'maven', image: 'maven:3.6.3-jdk-8', ttyEnabled: true, command: 'cat')
]) {
    node('maven') {
        stage('Build') {
            container('maven') {
                environment {
                    SONAR_LOGIN =  credentials('sonartoken')
                    SONAR_HOST = credentials('sonarhost')
                }
                stage("git clone") {
                    sh 'git clone --branch master --depth=1 https://github.com/jvoight0205/SimpleSeleniumWorkshop.git .'
                }
                stage('Build maven project') {
                    sh ("mvn verify sonar:sonar -Dsonar.host=$SONAR_HOST_PSW -Dsonar.login=$SONAR_LOGIN_PSW")
                }
            }
        }
    }
}