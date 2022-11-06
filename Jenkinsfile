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
              /*stage("nexus deploy"){
                                   steps {
                                      sh 'mvn deploy:deploy-file -DgroupId=com.esprit.examen -DartifactId=tpAchatProject -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://192.168.1.18:8081/repository/maven-releases -Dfile=target/tpAchatProject-1.0.jar'
                                           }
                                   }*/
             stage('MVN SONARQUBE'){
                            steps{
                               sh  'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=youssef123'
                            }
                      }
             }
        }
         stage('Building our image') {
                                                     steps {
                                                           sh 'docker build -t youssefkehili/tpachatprojet'
                                                       }
                                                   }


                                                     stage('Docker login') {
                                                                  steps {
                                                                            sh 'echo "login"'
                                                                            sh 'docker login -u youssefkehili -p youssef123'
                                                                  }
                                                            }
                                                               stage('Docker push') {
                                                                           steps {

                                                                                    sh 'echo "Docker push ..."'
                                                                                    sh 'docker push youssefkehili/tpachatprojet:156 '
                                                                           }
                                                                     }

    }

