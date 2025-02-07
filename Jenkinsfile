pipeline {
    agent any

    environment {
        SLACK_CHANNEL = 'jenkins'
        SLACK_CREDENTIALS_ID = 'Slack'
    }

    tools {
        maven 'Maven'
    }
    stages {
            stage('build') {
                steps {
                    bat 'mvn clean package'
                }
            }

            stage('Sonar code check'){
                steps{
                withSonarQubeEnv(credentialsId: 'SonarQube', installationName: 'SonarQube') {
                    bat 'mvn sonar:sonar \
                        -Dsonar.sources=src/main/java/com/sample/helloworld \
                        -Dsonar.tests=src/test/java/com/sample/helloworld \
                        -Dsonar.host.url=http://localhost:9000 \
                        -Dsonar.projectKey=DevOps'
                }
            }
            }

            stage('upload artifact in nexus repo'){
                steps {
                    nexusArtifactUploader(
                            nexusVersion: 'nexus3',
                            protocol: 'http',
                            nexusUrl: 'localhost:8081/repository/maven-releases/',
                            groupId: 'com.sample',
                            version: '1.0',
                            repository: 'maven-releases',
                            credentialsId: 'Nexus',
                            artifacts: [
                                [
                                    artifactId: 'helloworld',
                                    classifier: '',
                                    file: 'target/helloworld-1.0.jar',
                                    type: 'jar'
                                ]
                            ]
                        )
                }
            }
    }

    post{
        success{
            slackSend (
                channel:"${SLACK_CHANNEL}",
                tokenCredentialId: "${SLACK_CREDENTIALS_ID}",
                color:'good',
                message:"Build ${env.JOB_NAME} #${env.BUILD_NUMBER} succeeded. More detail: ${env.BUILD_URL}"
            )
        }
        failure{
            slackSend (
                channel:"${SLACK_CHANNEL}",
                tokenCredentialId: "${SLACK_CREDENTIALS_ID}",
                color:'danger',
                message:"Build ${env.JOB_NAME} #${env.BUILD_NUMBER} failed. More detail: ${env.BUILD_URL}"
            )
        }
    }
}