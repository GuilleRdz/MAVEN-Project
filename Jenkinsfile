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
                timeout(time: 1, unit: 'MINUTES') {
                waitForQualityGate abortPipeline: true
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
