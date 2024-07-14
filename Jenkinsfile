pipeline {
    agent any

    tools {
         maven 'Maven'
    }
    stages {
        stage('build') {
            steps {
                bat 'mvn clean package'
            }
        }
        stage('upload artifact in nexus repo'){
            steps {
                nexusArtifactUploader(
                        nexusVersion: 'nexus3',
                        protocol: 'http',
                        nexusUrl: 'localhost:8081/repository/maven-releases/',
                        groupId: 'com.cicd',
                        version: '1.0',
                        repository: 'maven-releases',
                        credentialsId: 'Nexus',
                        artifacts: [
                            [
                                artifactId: 'my-project',
                                classifier: '',
                                file: 'target/my-project-1.0.jar',
                                type: 'jar'
                            ]
                        ]
                    )
            }
        }
        stage('Sonar code check') {
            steps{
                withSonarQubeEnv(credentialsId: 'SonarQube', installationName: 'SonarQube') {
                bat 'mvn sonar:sonar \
                    -Dsonar.sources=src/main/java/hello \
                    -Dsonar.host.url=http://localhost:9000 \
                    -Dsonar.projectKey=DevOps'
            }
        }
    }
}
}