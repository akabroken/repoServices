pipeline {
    agent {
        label 'docker'
    }
    stages {
        stage('Building our image') {
            steps {
                script {
                    dockerImage = docker.build "reposervices/reposervices1:$BUILD_NUMBER"
                }
            }
        }
      
    }
}
