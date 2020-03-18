pipeline{
    agent any
    stages{
        stage('Deploy'){
            steps{
                echo 'Deploy'
            }
        }
        stage('Sonarqube') {
            environment {
                scannerHome = tool 'SonarQubeScanner'
            }    
            steps {
                withSonarQubeEnv(credentialsId:'sonar-txt', installationName:'SonarQube',) {
                    sh "${scannerHome}/bin/sonar-scanner"
                }        
            }
        }
    }
}
