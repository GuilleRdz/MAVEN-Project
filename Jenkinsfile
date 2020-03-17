node{
    stage('SCM Checkout'){
        git 'https://github.com/GuilleRdz/MAVEN-Project'
    }
    stage('Compile-Package'){
        sh 'mvn package'
    }
}
