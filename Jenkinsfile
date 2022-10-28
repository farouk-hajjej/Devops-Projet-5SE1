import java.text.SimpleDateFormat
pipeline {
agent any

stages {
    stage('Checkout GIT') {
        steps {
            echo 'Pulling .....';
            git branch : 'farouk-back',
            url : 'https://github.com/farouk-hajjej/Devops-Projet-5SE1.git'
          //credentialsId : ' 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 ' ;
        }
        }
          stage('Date') {
                      steps {
                           script{
                           def date = new Date()
                           sdf = new SimpleDateFormat("MM/dd/yyyy")
                           println(sdf.format(date))
                                   }

                             }
         }

          stage('MVN CLEAN'){
                 steps{
                     sh  'mvn clean'
                 }
             }
        stage('MVN COMPILE'){
            steps{
                sh  'mvn compile'
            }
        }

        stage('MVN PACKAGE'){
              steps{
                  sh  'mvn package'
              }
        }
         stage('MVN SONARQUBE')
                    {
                        steps{
                        sh  'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
                        }
                    }

}
}