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
                    githubPRAddLabels labelProperty: labels('pending')
                    sh("mvn compile")
                    githubPRStatusPublisher buildMessage: message(failureMsg: githubPRMessage('Can\'t set status; build failed.'),
                            successMsg: githubPRMessage('Can\'t set status; build succeeded.')),
                            statusMsg: githubPRMessage('${GITHUB_PR_COND_REF} run ended'),
                            statusVerifier: allowRunOnStatus('SUCCESS'),
                            unstableAs: 'FAILURE'
                }
                stage('Test project') {
                    sh("mvn verify")
                    githubPRAddLabels labelProperty: labels('passed'), statusVerifier: allowRunOnStatus('SUCCESS')
                }
                stage('lint') {
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