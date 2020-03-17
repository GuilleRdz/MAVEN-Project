pipeline {
    agent any
    stages{
        stage('Build'){
            steps{
                /* BuildApplication */
                sh 'cd MAVENProject'
                sh 'mvn clean install -e -DskipTests'
            }
        }
        stage('Unit Test'){
            steps{
                echo 'Unit Test'
                sh 'cd MAVENProject'
                sh 'mvn test'
            }
        }
        stage('Static Analysis'){
            steps{
                echo 'SonarQube'
            }
        }
    }
}
