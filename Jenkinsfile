node{
    stage('SCM Checkout'){
        steps{
            git 'https://github.com/GuilleRdz/MAVEN-Project/tree/Dev'
    }
    stage('Compile-Package'){
        sh 'mvn package'
    }
}
