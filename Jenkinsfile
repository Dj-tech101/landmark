pipeline {
    agent any

    stages {
        stage('Checkout SCM') {
            steps {
                // Check out the code from the Git repository
                checkout scm
            }
        }

        // Optionally, you may want to specify the tool installation here if needed

        stage('lkstage') {
            steps {
                // Check out the code from the specified branch (DjBranch)
                checkout([$class: 'GitSCM', branches: [[name: '*/DjBranch']], userRemoteConfigs: [[url: 'https://github.com/Dj-tech101/landmark.git']]])
             bat 'mvn clean install'
            }
        }
    }

    post {
        success {
            echo 'Build successful! You can add more post-build actions here.'
        }

        failure {
            echo 'Build failed! You can add more post-failure actions here.'
        }
    }
}
