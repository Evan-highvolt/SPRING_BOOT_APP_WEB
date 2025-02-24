pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'JDK21'
    }

    stages {

        stage('Clean WS') {
            steps {
                    cleanWs()
            }
        }

        stage('Git Checkout') {
            steps {
                git (branch: 'main',
                        credentialsId: '9595',
                        url: 'https://github.com/Evan-highvolt/SPRING_BOOT_APP_WEB.git')
            }
        }

        stage('Build maven') {
            steps {
                script {
                    bat 'mvn clean package'
                }
            }
        }

        stage('Build Docker image') {
            steps {
                script {
                    docker.build('evanhighvolt/webapp_img', '-f Dockerfile .')
                }

            }
        }

        stage('Push to Docker Hub') {
            steps {
                script {
                    docker.withRegistry('', 'docker') {
                        docker.image('evanhighvolt/webapp_img').push()
                    }
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