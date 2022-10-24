pipeline {
agent any

stages {
    stage('Checkout GIT') {
        steps {
            echo 'Pulling .....';
            git branch : 'farouk-back',
            url : 'https://github.com/farouk-hajjej/Devops-Projet-5SE1.git'
           credentialsId : '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' ;
        }
        }
        stage('Maven build') {
                steps {
                    echo 'Build App'

                }
         }

     stage('Maven test') {
                    steps {
                        echo 'Test App'

                    }
      }

}


}