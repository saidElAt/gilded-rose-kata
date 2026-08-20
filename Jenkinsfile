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
    }

    post {

        always {
            junit testResults: 'target/surefire-reports/*.xml',
                  allowEmptyResults: true
        }

        success {
            archiveArtifacts artifacts: 'target/*.jar',
                             fingerprint: true
        }
    }
}