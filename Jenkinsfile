def artifact
pipeline {
    agent {
        label 'docker'
    }
    // configure environmental variables
    environment {
	registry = "https://registry.hub.docker.com"
	registryCredentials = "dockerhub"
    }
    
    // instruct jenkins to allocate executor and workspace for entire pipeline agent any
    
    stages {
    	// compile and generate single executable jar with all dependencies
	stage('Build') {
            steps {
                bat 'mvn install'
            }
        }
        
        // build docker image of an application
	stage('Package') {
            steps {
                script {
                    artifact = docker.build("amahas123/reposervices:$BUILD_NUMBER")
                }
            }
        }
        // push built docker image to docker hub
	stage('Publish') {
            steps {				
                script {
                    docker.withRegistry(registry, registryCredentials) {
      			artifact.push()
                    }
                }
            }
        }
    }
}