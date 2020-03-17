node{
    stage('SCM Checkout'){
        git 'https://github.com/GuilleRdz/MAVEN-Project/tree/Dev'
    }
    stage('Compile-Package'){
        sh 'mvn package'
    }
}
