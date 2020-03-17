node{
    stage('SCM Checkout'){
        when {
                branch 'dev'
        }
        git 'https://github.com/GuilleRdz/MAVEN-Project'
    }
    stage('Compile-Package'){
        sh 'mvn package'
    }
}
