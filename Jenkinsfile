pipeline {
agent any

stages {
    stage('Checkout GIT') {
        steps {
            echo 'Pulling .....';
            git branch : 'farouk-back',
            url : 'https://github.com/farouk-hajjej/Devops-Projet-5SE1.git'
          //  credenttialsId : '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' ;
        }
        }
        stage('Build') {
                steps {
                    echo 'Build App'

                }
                }

     stage('Test') {
                    steps {
                        echo 'Test App'

                    }
        }
        }
}


}