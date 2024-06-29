pipeline{
    agent {
        label "jenkins-agent"
    }

    tools{
        jdk 'Java17'
        maven "Maven3"
    }


    environment {
        DOCKER_CREDENTIALS_ID = 'dockerhub'
        DOCKER_HUB_REPO = 'salindadocker/otto-rent-backend'
        EC2_SSH_KEY = 'host-instace-keypair-id'
        EC2_HOST_IP = '34.204.43.159'
        DOCKERHUB_API_URL = "https://hub.docker.com/v2/repositories/salindadocker/otto-rent-backend/"
        JENKINS_API_TOKEN = 'JENKINS_API_TOKEN'
    }

    stages{

        stage("Clean Workspace"){
            steps{
                cleanWs()
            }
         } 

        stage('Checkout'){
            steps{
                git branch: 'main',credentialsId: 'github', url: 'https://github.com/SalindaGunarathna/Otto-rent-system-backend.git'
            }
        }

        stage('Build'){
            steps{
                sh 'mvn clean package' 
            }
        }

        stage('Test'){
            steps{
                sh 'mvn test' 
            }
        }
        
        stage('Build Docker Image') {
            steps {
                script {
                    
                    dockerImage = docker.build("${env.DOCKER_HUB_REPO}:28.${env.BUILD_NUMBER}")
                }
            }
        }

        stage('Push Docker Image to Docker Hub') {
            steps {
                script {
                   
                    docker.withRegistry('https://registry.hub.docker.com', DOCKER_CREDENTIALS_ID) {
                        dockerImage.push("22.${env.BUILD_NUMBER}")
                        dockerImage.push("latest")
                    }
                }
            }
        }



    }

}