pipeline {
    agent any

    environment {
        NEXUS_URL = 'http://nexus.example.com:8081/repository/maven-releases/'
        NEXUS_CREDENTIALS_ID = 'Nexus'
        GROUP_ID = 'com.cicd'
        ARTIFACT_ID = 'my-project'
        VERSION = '1.0'
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
        stage('upload artifact in nexus repo'){
            steps {
                nexusArtifactUploader(
                nexusVersion: 'nexus3',
                protocol: 'http',
                nexusUrl: 'localhost:8081/#browse/browse:maven-releases',
                groupId: 'com.cicd',
                version: '1.0',
                repository: 'maven-releases',
                credentialsId: 'Nexus',
                artifacts: [
                            [artifactId: projectName,
                            classifier: '',
                            file: 'CICD pipeline\target\my-project-1.0.jar',
                            type: 'jar']
                ]
                )
            }
        }
    }
}