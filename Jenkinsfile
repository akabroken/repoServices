pipeline {
    agent {
        label 'docker'
    }
    stages {
        stage('Building our image') {
            steps {
                script {
                    dockerImage = docker.build "reposervices/reposervices:$BUILD_NUMBER"
                }
            }
        }
      
    
    stage('Deploy our image') {
            steps {
                script {
                    // Assume the Docker Hub registry by passing an empty string as the first parameter
                      withCredentials([usernamePassword( credentialsId: 'dockerhub', usernameVariable: 'amahas123', passwordVariable: 'Cuchaza@ken123')]) {
                     def registry_url = "registry.hub.docker.com/"
                    bat "docker login -u $USER -p $PASSWORD ${registry_url}"
                    docker.withRegistry("http://${registry_url}" , 'dockerhub') {
                        dockerImage.push()
                    }
                   }
                }
            }
        }
    }
}
