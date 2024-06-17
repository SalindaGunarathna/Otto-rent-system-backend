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
                    
                    dockerImage = docker.build("${env.DOCKER_HUB_REPO}:${env.BUILD_NUMBER}")
                }
            }
        }

        stage('Push Docker Image to Docker Hub') {
            steps {
                script {
                   
                    docker.withRegistry('https://registry.hub.docker.com', DOCKER_CREDENTIALS_ID) {
                        dockerImage.push("${env.BUILD_NUMBER}")
                        dockerImage.push("latest")
                    }
                }
            }
        }

        

        stage('Deploy to EC2'){
            steps{
                script {
                    withCredentials([
                        sshUserPrivateKey(credentialsId: EC2_SSH_KEY, keyFileVariable: 'SSH_KEY'),

                    ]) {

                        sh """
                        ssh -i "$SSH_KEY" -o StrictHostKeyChecking=no ubuntu@${EC2_HOST_IP} '
                            sudo docker pull ${DOCKER_HUB_REPO}:latest
                            sudo docker stop otto-rent-backend || true
                            sudo docker rm otto-rent-backend || true
                            sudo docker run -d -p 8080:8080 --name otto-rent-backend ${DOCKER_HUB_REPO}:latest
                        '
                        """
                    }
                }
            }
        }




    }

}