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
        environment {
                registryDomain = "hub.docker.com"
                registry = "https://${registryDomain}"
                registryCredential = 'dockerhub'
                PATH = "${dockerHome}/bin:${env.PATH}"
                repo = "test"
                project = "reposervices"
                version = sh(returnStdout: true, script: 'git rev-parse HEAD').trim()
                fullName = "${registryDomain}/${repo}/${project}"
            }
            steps {
                container('docker') {
          script{
            def defaultLatestImage = docker.build("${fullName}", ".")
            def taggedImage = docker.build("${fullName}:${version}", ".")
            docker.withRegistry(registry, registryCredential) {
              defaultLatestImage.push()
              taggedImage.push()
            }
          }
        }
      }
           
                
    }
}
