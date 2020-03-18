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
                withSonarQubeEnv('SonarPuerto') {
                    sh "${scannerHome}/bin/sonar-scanner"
                }        
            }
        }
        stage('Deploy II'){
            steps{
                echo 'Despues de Sonar'
            }
        }
    }
}
