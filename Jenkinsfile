pipeline{
    agent any
    stages{
        stage('Validate'){
            steps{
                sh 'mvn validate'
            }
        }
        stage('Clean'){
            steps{
                sh 'mvn clean'
            }
        }
        stage('Lint Code'){
            steps{
                sh 'mvn checkstyle:check'
            }
        }
        stage('Unit Test'){
            steps{
                sh 'mvn test'
        }

        }
        stage('Static Analysis') {
            environment {
                scannerHome = tool 'SonarQubeScanner'
            }
            steps {
                withSonarQubeEnv('SonarCloud') {
                    sh "${scannerHome}/bin/sonar-scanner"
                }
                timeout(time: 1, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
    }
}
