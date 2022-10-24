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