pipeline {
    agent any 

    tools {
        maven "maven3" // Tool name should be lowercase
    }

    stages {
        stage("Git Checkout") { // Stage names should be camelCase
            steps { // Use "steps" block for stage actions
                git branch: 'main',
                    url: 'https://github.com/ash2code/Java-Clock-with-Swing.git'
            }
        }

        stage("Code Build") {
            steps {
                sh "mvn clean install"
            }
        }

        // Consider adding a deployment stage if needed
    }
}
