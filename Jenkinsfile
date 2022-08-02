pipeline {
    agent {
        label 'docker'
    }
    tools {
        jdk 'jdk'
        maven '3.8.6'
       
    }
    stages {
        stage('Building') {
            steps {
                script {
                    //dockerImage = docker.build "amahas123/reposervices:$BUILD_NUMBER"
                    echo "Java VERSION"
                    sh 'java -version'
                    echo "Maven VERSION"
                    sh 'mvn -version'
                    echo 'building project...'
                    sh "mvn compile"
                    sh "mvn package"
                    //sh "mvn test"
                    sh "mvn clean install"
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    // Assume the Docker Hub registry by passing an empty string as the first parameter
                    docker.withRegistry('https://registry.hub.docker.com/' , 'dockerhub') {
                        dockerImage.push()
                    }
                }
            }
        }
    }
}
