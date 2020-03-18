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
                withSonarQubeEnv(credentialsId:'puerto', installationName:'SonarPuerto',) {
                    sh "${scannerHome}/bin/sonar-scanner"
                }        
            }
        }
    }
}
