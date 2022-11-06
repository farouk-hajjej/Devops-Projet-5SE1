import java.text.SimpleDateFormat
pipeline {
agent any

stages {
    stage('Checkout GIT') {
        steps {
            echo 'Pulling .....';
            git branch : 'youssef-back',
            url : 'https://github.com/farouk-hajjej/Devops-Projet-5SE1.git'
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
                     sh  'mvn clean install'
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
               stage("nexus deploy"){
                                   steps {
                                      sh 'mvn deploy'
                                           }
                                      }
        }
    }