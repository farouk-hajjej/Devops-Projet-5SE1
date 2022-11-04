import java.text.SimpleDateFormat
pipeline {
environment {
        registry = "faroukhajjej1/projet-devops"
        registryCredential = 'dckr_pat_HnIKKGgZvJoyNbu0Vkoic55XsuQ'
        dockerImage = ''
    }
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
        stage("Sonar Quality Check"){
                		steps{
                		    script{
                		     withSonarQubeEnv(installationName: 'SonarQube-Projet', credentialsId: 'jenkins-sonar-token') {
                		     sh 'mvn sonar:sonar'
                	    	       }
                	         }
                       }
                 }
           stage("Test JUnit /Mockito"){
                                 steps {
                                             sh 'mvn test'
                                 }
                           }
                           stage('Building our image') {
                                               steps {
                                                   script {
                                                       dockerImage = docker.build registry + ":$BUILD_NUMBER"
                                                   }
                                               }
                                           }

                                           stage('Deploy our image') {
                                               steps {
                                                   script {
                                                      withCredentials([string(credentialsId: 'dockerdevops', variable: 'dockerpwd')]) {
                                                          sh 'docker login -u faroukhajjej1 -p ${dockerhubpwd}'
                                                          }
                                                           sh 'docker push faroukhajjej1/projet-devops'
                                                      }
                                                   }

                                          }
                                           stage('Cleaning up') {
                                               steps {
                                                   sh "docker rmi $registry:$BUILD_NUMBER"
                                               }
                                           }




}
}