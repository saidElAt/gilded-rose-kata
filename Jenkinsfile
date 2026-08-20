pipeline {

    agent any

    options {
        skipDefaultCheckout(true)
        timestamps()
        disableConcurrentBuilds()
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build and Test') {
            steps {
                sh 'sh mvnw -B clean package'
            }
        }

        stage('Smoke Test') {
            steps {
                sh 'java -jar target/gilded-rose-kata-1.0-SNAPSHOT.jar'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t gilded-rose-kata:${BUILD_NUMBER} .'
            }
        }

        stage('Docker Smoke Test') {
            steps {
                sh 'docker run --rm gilded-rose-kata:${BUILD_NUMBER}'
            }
        }
    }

    post {

        always {
            junit testResults: 'target/surefire-reports/*.xml',
                  allowEmptyResults: true

            sh 'docker image rm gilded-rose-kata:${BUILD_NUMBER} || true'
        }

        success {
            archiveArtifacts artifacts: 'target/*.jar',
                             fingerprint: true
        }
    }
}