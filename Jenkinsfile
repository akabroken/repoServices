
pipeline {
  agent {
      node {
          label 'maven-docker-worker'
      }
  }
  stages {
    stage('Package') {
      steps {
        container('maven') {
          sh 'mvn package'
        }
      }
    }
    stage('Static Analysis') {
      environment {
        scannerHome = tool 'SonarQube'
      }
      steps {
        container('sonar-scanner') {
          withSonarQubeEnv('SonarQube') {
            sh "${scannerHome}/bin/sonar-scanner"
          }
        }
      }
    }
    stage('Deploy') {
      environment {
        registryDomain = "docker.interswitch.co.ke:30003"
        registry = "https://${registryDomain}"
        registryCredential = 'docker-credentials'
        PATH = "${dockerHome}/bin:${env.PATH}"
        repo = "test"
        project = "repoServices"
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
}