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
    }
}