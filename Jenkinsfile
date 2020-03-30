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
    agent any
    stages {
        stage('build') {
            steps {
               echo "Build stage"
            }
        }
        stage('test') {
            steps {
               echo "Test stage"
            }
        }
        stage('integration test') {
            steps {
               echo "Integration Test stage"
            }
        }
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