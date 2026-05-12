pipeline {
    agent any
    parameters {
        string description: 'Commit id to build', name: 'COMMIT'
        choice choices: ['main', 'feature'], description: 'Branch of commit id to build', name: 'BRANCH'
    }

    stages{
        stage('Build') {
            steps {
                script {
                    echo('Start build step')
                }
            }
        }
    }
}
