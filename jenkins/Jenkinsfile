pipeline {
    agent any
    environment {
        DOCKER_IMAGE = "gauravcap01/user-service"
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/gauravcap01/springboot_microservice_gradle_project_with_docker_jenkins_k8s.git'
            }
        }
        stage('Build') {
            steps {
                sh 'gradle build -x test'
            }
        }
        stage(' ') {
            steps {
                sh './gradlew test'
            }
        }
        stage('Docker Build & Push') {
            steps {
                script {
                    docker.build("${DOCKER_IMAGE}:${BUILD_NUMBER}").push()
                }
            }
        }
        stage('Ansible Deploy') {
            steps {
                sh 'ansible-playbook ansible/deploy-k8s.yml'
            }
        }
    }
}