pipeline {
  environment {
    GIT_URL = "https://github.com/yanzxu/user-service.git"
    GIT_CREDENTIAL = 'yanzxu'
    registryCredential = 'dockerhub'
    dockerImage = ''
  }
  agent any
  stages {
    stage('Checkout') {
      steps {
        checkout changelog: true, poll: true,
        scm: [$class: 'GitSCM', branches: [[name: '*/master']],
        doGenerateSubmoduleConfigurations: false,
        extensions: [[$class: 'CleanBeforeCheckout']], submoduleCfg: [],
        userRemoteConfigs: [[credentialsId: "${GIT_CREDENTIAL}", url: "${GIT_URL}"]]]
      }
    }

    stage('Build') {
        steps {
            sh "${tool name: 'gradle', type: 'hudson.plugins.gradle.GradleInstallation'}/bin/gradle clean build"
        }
    }

    stage('Building image') {
      steps{
        script {
          dockerImage = docker.build registry + ":$BUILD_NUMBER"
        }
      }
    }
    stage('Deploy Image') {
      steps{
        script {
          docker.withRegistry( '', registryCredential ) {
            dockerImage.push()
          }
        }
      }
    }
    stage('Remove Unused docker image') {
      steps{
        sh "docker rmi $registry:$BUILD_NUMBER"
      }
    }
  }
}