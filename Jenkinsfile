podTemplate(label: 'maven', containers: [
        containerTemplate(name: 'maven', image: 'maven:3.6.3-jdk-8', ttyEnabled: true, command: 'cat')
]) {
    node('maven') {
        stage('Build') {
            container('maven') {
                stage("git clone") {
                    checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/jvoight0205/SimpleSeleniumWorkshop.git']]])
                }
                stage('Build maven project') {
                    withCredentials([string(credentialsId: 'sonartoken', variable: 'SONAR_LOGIN'), string(credentialsId: 'sonarhost', variable: 'SONAR_HOST')]) {
                        sh ("mvn verify sonar:sonar -Dsonar.host.url=$SONAR_HOST -Dsonar.login=$SONAR_LOGIN")
                    }
                }
                post {
                    always {
                        junit 'target/failsafe-reports/junitreports/*.xml,target/surefire-reports/junitreports/*.xml'
                        archiveArtifacts artifacts: 'target/failsafe-reports/*,target/surefire-reports/*', followSymlinks: false
                    }
                }
            }
        }
    }
}