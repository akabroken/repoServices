pipeline {
    agent {
        label 'docker'
    }
    stages {
        stage('Building our image') {
            steps {
                script {
                    dockerImage = docker.build "rootest/petclinic:$BUILD_NUMBER"
                }
            }
        }
      
    }
}
