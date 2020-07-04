podTemplate(label: 'maven', containers: [
        containerTemplate(name: 'maven', image: 'maven:3.6.3-jdk-8', ttyEnabled: true, command: 'cat')
]) {
    node('maven') {
        stage('Maven') {
            container('maven') {
                stage("git clone") {
                    checkout([$class: 'GitSCM', branches: [[name: "$env.CHANGE_BRANCH"]], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/jvoight0205/SimpleSeleniumWorkshop.git']]])
                }
                stage('Build project') {
                    sh("mvn compile")
                }
                stage('Test project') {
                    sh("mvn verify")
                }
                stage('lint')
                    withCredentials([string(credentialsId: 'sonartoken', variable: 'SONAR_LOGIN'), string(credentialsId: 'sonarhost', variable: 'SONAR_HOST')]) {
                        sh ("mvn sonar:sonar -Dsonar.host.url=$SONAR_HOST -Dsonar.login=$SONAR_LOGIN")

                    }
                stage('archive') {
                    junit 'target/surefire-reports/*.xml'
                    archiveArtifacts artifacts: 'target/surefire-reports/*,target/cucumber-html-reports/**/*', followSymlinks: false
                }
            }
        }
    }
}