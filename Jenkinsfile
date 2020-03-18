pipeline{
    agent any
    stages{
        stage('Maven Lifecycle'){
            parallel{
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
                stage('Unit Test'){
                    steps{
                        sh 'mvn Test'
                    }
                }
            }
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
        stage('Delivery on Dev'){
            when {
                branch 'Dev'
            }
            steps{
                echo 'Delivery...'
            }
        }
        stage('Deploy for Prod'){
            when{
                branch 'master'
            }
            steps{
                echo 'Deploying...'
            }
        }
    }
}
