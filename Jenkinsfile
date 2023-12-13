pipeline {
    agent any

    stages {
        stage('lkstage') {
            steps {
                // Checkout the code from version control
                checkout scm
            }
        }

        stage('Testing stage') {
            steps {
                // Build the project (replace 'mvn clean install' with your build command)
                sh 'mvn clean install'
            }
        }

        
    }

    post {
        success {
            emailext body: 'Test Automation', subject: 'Test', to: 'mahesh@sstsoftwareservices.com'
            echo 'Build and deployment successful!'
        }

       
    }
}
