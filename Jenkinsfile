pipeline {
    agent {
     //   label 'docker'
        kubernetes {
      label 'maven-docker-worker'
      defaultContainer 'jnlp'
      idleMinutes '360'
      instanceCap '5'
      yaml """
apiVersion: v1
kind: Pod
metadata:
  namespace: jenkins
labels:
  component: ci
spec:
  # Use service account that can deploy to all namespaces
  # serviceAccountName: cd-jenkins
  containers:
  - name: maven
    image: maven:3.6.3-jdk-11
    imagePullPolicy: IfNotPresent
    command:
    - cat
    tty: true
    volumeMounts:
      - mountPath: "/root/.m2"
        name: m2
  - name: sonar-scanner
    image: sonarsource/sonar-scanner-cli
    imagePullPolicy: IfNotPresent
    command:
    - cat
    tty: true
  - name: docker
    image: docker:19.03.13
    imagePullPolicy: IfNotPresent
    command:
    - cat
    tty: true
    volumeMounts:
    - mountPath: /var/run/docker.sock
      name: docker-sock
  volumes:
    - name: docker-sock
      hostPath:
        path: /var/run/docker.sock
    - name: m2
      persistentVolumeClaim:
        claimName: m2
---
"""
    }
  }
    
 
    stages {
         stage('Test') {
       steps {
         container('maven') {
           sh "mvn test"
         }
       }
     }
    stage('Package') {
      steps {
        container('maven') {
          sh 'mvn package'
        }
      }
    }
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
