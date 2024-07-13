pipeline {
    agent any

    environment {
        NEXUS_URL = 'http://nexus.example.com:8081/repository/maven-releases/'
        NEXUS_CREDENTIALS_ID = 'admin'
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
        stage('upload artifact in nexus'){
            steps {
                script{
                    def jarFile = "target/*.jar"

                    nexusArtifactUploader(
                        nexusVersion: 'nexus3',
                        protocol: 'http',
                        nexusUrl: env.NEXUS_URL,
                        groupId: env.GROUP_ID,
                        version: env.VERSION,
                        repository: 'maven-releases',
                        credentialsId: env.NEXUS_CREDENTIALS_ID,
                        artifacts: [
                            [
                                artifactId: env.ARTIFACT_ID,
                                classifier: '',
                                file: jarFile,
                                type: 'jar'
                            ]
                        ]
                    )
            }
        }
    }
}
}