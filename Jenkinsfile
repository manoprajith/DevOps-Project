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
        stage('upload artifact in nexus'){
            steps {
            nexusArtifactUploader artifacts: [[artifactId: 'my-project', classifier: '', file: '**/*.war', type: 'war']], credentialsId: 'Nexus', groupId: 'com.cicd', nexusUrl: 'http://localhost:8081/repository/maven-releases/', nexusVersion: 'nexus3', protocol: 'http', repository: 'maven-releases', version: '1.0'
            }
        }
    }
}