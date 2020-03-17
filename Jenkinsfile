node{
    stage('SCM Checkout'){
        steps{
            git checkout 'Dev'
            git 'https://github.com/GuilleRdz/MAVEN-Project'
        }
    }
    stage('Compile-Package'){
        sh 'mvn package'
    }
}
