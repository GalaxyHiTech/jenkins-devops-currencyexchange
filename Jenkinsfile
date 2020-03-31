// SCRIPTED PIPELINE
// node {
//     stage('Build') {
//         echo "Build"
//     }
//     stage('Test') {
//         echo "Test"
//     }
//     stage('Integration Test') {
//         echo "Integration Test"
//     }
// }

// DECLARATIVE PIPELINE
pipeline {
    // agent {
    //     docker {
    //         image 'maven:3.6.3'
    //     }
    // }
    agent any
    environment {
        dockerHome = tool 'myDocker'
        mavenHome = tool 'myMaven'
        PATH = "$dockerHome/bin:$mavenHome/bin:$PATH"
    }
    stages {
        stage('Checkout') {
            steps {
               sh 'mvn --version'
               sh 'docker --version'
               echo "Build stage"
               echo "$PATH"
               echo "BUILD_NUMBER - $env.BUILD_NUMBER"
               echo "BUILD_ID - $env.BUILD_ID"
               echo "JOB_NAME - $env.JOB_NAME"
               echo "BUILD_TAG - $env.BUILD_TAG"
               echo "BUILD_URL - $env.BUILD_URL"
               
            }
        }
        stage {
            steps {
                sh "mvn clean package"
            }
        }
        stage('test') {
            steps {
               sh "mvn test"
            }
        }
        stage('integration test') {
            steps {
               sh "mvn failsafe:integration-test failsafe:verify"
            }
        }
        /* stage('build docker image') {
            steps {
                // sh "docker build -t galaxyhightech/jenkins-devops-currency-exchange:$env.BUILD_TAG"
                script {
                    dockerImage = docker.image("galaxyhightech/jenkins-devops-currency-exchange:${env.BUILD_TAG}")
                }
            }
        }
        stage('push docker image') {
            steps {
                script {
                    docker.registerWith('', 'dockerhub') {

                    }
                }
            }
        } */
    }
    post {
        always {
            echo "I run always"
        }
        success {
            echo "I run when you are successful"
        }
        failure {
            echo "I run when you are fail"
        }
    }
}