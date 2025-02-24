pipeline {
    agent any

    stages {

        stage('CleanWS') {
            steps {
                script {
                    cleanWs()
                }
            }
        }

        stage('Git Checkout') {
            steps {
                git branch: 'main',
                        credentialsId: 'root',
                        url: 'https://github.com/Evan-highvolt/SPRING_BOOT_APP_WEB.get'
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
                    def image = docker.build('evanhighvolt/webapp_img')
                    image.push()
                }

            }
        }

        stage('Docker Compose') {
            steps {
                script {
                    bat 'docker-compose up -d'
                }
            }
        }
    }
}