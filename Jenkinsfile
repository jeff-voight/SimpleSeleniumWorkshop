GString labelMVN = "selenium-workshop-build-${UUID.randomUUID().toString()}"

podTemplate(label: labelMVN,
        containers: [
        containerTemplate(name: 'maven',
                image: 'voight/mvn-jdk-1.8:1.6',
                ttyEnabled: true,
                alwaysPullImage: true,
                command: 'cat'),
        containerTemplate(name: 'jnlp', image: 'jenkins/inbound-agent:latest-jdk11', args: '${computer.jnlpmac} ${computer.name}')
        ]) {
    node(labelMVN) {
        stage('Container') {
            container('maven') {
                stage("Clone") {
                    checkout([$class                           : 'GitSCM',
                              branches                         : scm.branches,
                              doGenerateSubmoduleConfigurations: scm.doGenerateSubmoduleConfigurations,
                              extensions
                              : scm.extensions,
                              submoduleCfg                     : [],
                              userRemoteConfigs                : scm.userRemoteConfigs
                    ])
                }
                stage('Build project') {
                    sh("mvn compile")
                }
                stage('Test project') {
                    sh("mvn verify")
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