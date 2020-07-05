podTemplate(label: 'maven', containers: [
        containerTemplate(name: 'maven', image: 'maven:3.6.3-jdk-8', ttyEnabled: true, command: 'cat')
]) {
    node('maven') {
        stage('Container') {
            container('maven') {
                stage("Clone") {
                    checkout([$class                           : 'GitSCM',
                              branches                         : scm.branches,
                              doGenerateSubmoduleConfigurations: scm.doGenerateSubmoduleConfigurations,
                              extensions                       : scm.extensions,
                              submoduleCfg                     : [],
                              userRemoteConfigs                : scm.userRemoteConfigs
                    ])
                }
                stage('Build project') {
                    gitHubPRStatus 'compiling'
                    sh("mvn compile")
                }
                stage('Test project') {
                    gitHubPRStatus 'testing'
                    sh("mvn verify")
                    gitHubPRAddLabels 'passed'
                }
                stage('lint') {
                    gitHubPRStatus 'linting'
                    withCredentials([string(credentialsId: 'sonartoken', variable: 'SONAR_LOGIN'), string(credentialsId: 'sonarhost', variable: 'SONAR_HOST')]) {
                        sh("mvn sonar:sonar -Dsonar.host.url=$SONAR_HOST -Dsonar.login=$SONAR_LOGIN")
                    }
                }
                stage('archive') {
                    junit 'target/surefire-reports/*.xml'
                    archiveArtifacts artifacts: 'target/surefire-reports/*,target/cucumber-html-reports/**/*', followSymlinks: false
                }
            }
        }
    }
}