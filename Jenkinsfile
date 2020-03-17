node{
    stage('SCM Checkout'){
        git branch: 'Dev',
        credentialsId: 'maven-pj',
        url: 'https://github.com/GuilleRdz/MAVEN-Project'
    }
    stage('Compile-Package'){
        sh 'mvn package -DskipTests'
    }
    stage('Unit Test'){
        sh 'mvn test'
    }
}
