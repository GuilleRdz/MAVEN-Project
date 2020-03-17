agent any
    stages{
        stage('Build'){
            sh 'mvn package -DskipTests'
        }
        stage('Unit Test'){
            steps{
                sh 'mvn test'
            }
        }
        stage('Static Analysis'){
            steps{
                echo 'SonarQube'
            }
        }
        stage('Delivery on Dev'){
            when {
                branch 'Dev'
            }
            git: credentialsId: 'mavn-pj',
                url: 'https://github.com/GuilleRdz/MAVEN-Project'
        }
        stage('Deploy for Prod'){
            when{
                branch 'master'
            }
            stage{
                echo 'Deploying...'
            }
        }
    }
}
