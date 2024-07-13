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
    }
}