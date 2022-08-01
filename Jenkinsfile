pipeline {
    agent {
        label 'docker'
    }
    stages {
        stage('Building') {
            steps {
                script {
                    dockerImage = docker.build "amahas123/reposervices:$BUILD_NUMBER"
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    // Assume the Docker Hub registry by passing an empty string as the first parameter
                    docker.withRegistry('https://hub.docker.com/' , 'dockerhub') {
                        dockerImage.push()
                    }
                }
            }
        }
    }
}
