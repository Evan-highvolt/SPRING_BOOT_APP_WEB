#!groovy

pipeline {
    agent any
    stages {
        stage('Git Checkout') {
         steps {
            script {
                    git branch: 'main',
                    credentialsId: '9595'
                    url: 'https://github.com/Evan-highvolt/SPRING_BOOT_APP_WEB'
                     }
            }

        }

        stage('Clean workspace') {
            steps {
                cleanWs()
            }
        }

        stage('Build maven') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Build Docker image') {
            steps {
                script {
                    docker.withRegistry('', '9595')
                    docker.build('evan-highvolt/SPRING_BOOT_APP_WEB').push()
                }

            }
        }
        stage('push to Docker Hub') {
            steps {
                script {
                    docker.withRegistry('', '9595') {
                        docker.image('evan-highvolt/SPRING_BOOT_APP_WEB').push()

                    }
                }
            }
        }

    }


}