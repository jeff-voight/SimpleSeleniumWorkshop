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
                    gitHubPRStatus statusMessage: githubPRMessage('building')
                    sh("mvn compile")
                }
                stage('Test project') {
                    gitHubPRStatus statusMessage: githubPRMessage('testing')
                    sh("mvn verify")
                    githubPRAddLabels labelProperty: githubPRLabel('passed')
                }
                stage('lint') {
                    gitHubPRStatus statusMessage: githubPRMessage('linting')
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