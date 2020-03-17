node{
    stage('SCM Checkout'){
        git branch: 'Dev',
        credentialsId: 'mavn-pj',
        url: 'https://github.com/GuilleRdz/MAVEN-Project'
    }
    stage('Compile-Package'){
        sh 'mvn package'
    }
}
