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
                /*withSonarQubeEnv('SonarCloud') {
                    sh "${scannerHome}/bin/sonar-scanner"
                }
                timeout(time: 1, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }*/
                echo 'Testing on Delivery'
            }
        }
        stage('Delivery on Dev'){
            when {
                branch 'Dev'
            }
            steps{
                withCredentials([usernamePassword(credentialsId: 'webserver_login', usernameVariable: 'USER', passwordVariable: 'PASS')]){
                    sshPublisher(
                        failOnError: true,
                        continueOnError: false,
                        publishers: [
                            sshPublisherDesc(
                                configName: 'developmentenv',
                                sshCredentials: [
                                    username: "$USER",
                                    password: "$PASS",
                                    encryptesPassphrase: ''
                                ],
                                transfers: [
                                    sshTransfer(
                                        sourceFiles:'var/lib/jenkins/workspace/MAVEN-Project_Dev/',
                                        removePrefix: '/var/lib/jenkins/workspace/',
                                        remoteDirectory: '~',
                                        execCommand: 'rm -rf ~/MAVEN-Project_Dev/ && cd MAVEN-Project_Devls/target/ && java -jar cidr-api-1.0-SNAPSHOT.jar'
                                    )
                                ]
                            )
                        ]
                    )
                }
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
