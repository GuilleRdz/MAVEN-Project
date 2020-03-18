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
                withSonarQubeEnv(credentialsId:'sonar-cloud', installationName:'SonarCloud',) {
                    sh "${scannerHome}/bin/sonar-scanner"
                }        
            }
        }
    }
}
