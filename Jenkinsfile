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
        EC2_SSH_KEY = credentials('host-instace-keypair-id')
        EC2_HOST = '34.204.43.159'
        DOCKERHUB_API_URL = "https://hub.docker.com/v2/repositories/${DOCKERHUB_REPO}/"
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

        
        stage('Make Image to publish'){
            steps{
                script{
                    withCredentials([usernamePassword(credentialsId: DOCKER_CREDENTIALS_ID, usernameVariable: 'DOCKERHUB_USERNAME', passwordVariable: 'DOCKERHUB_TOKEN')]) {
                        sh """
                        curl -u $DOCKERHUB_USERNAME:$DOCKERHUB_TOKEN \
                             -X PATCH \
                             -H "Content-Type: application/json" \
                             -d '{"is_private": false}' \
                              $DOCKERHUB_API_URL
                        """
                    }
                }
            }
        }

        stage('Deploy to EC2'){
            steps{
                script{
                    sshagent(['EC2_SSH_KEY']) {

                       sh """
                       ssh -o StrictHostKeyChecking=no ubuntu@${EC2_HOST} '
                       sudo docker pull ${DOCKER_HUB_REPO}:latest &&
                       sudo docker stop otto-rent-backend || true &&
                       sudo docker rm otto-rent-backend || true &&
                       sudo docker run -d -p 8080:8080 --name otto-rent-backend ${DOCKER_HUB_REPO}:latest
                    '
                    """
                    }
                }
            }
        }




    }

}