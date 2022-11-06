import java.text.SimpleDateFormat
pipeline {
agent any
/**environment {
        registry = "faroukhajjej1/projet-devops"
        registryCredential = 'dckr_pat_ozDP-TtLooTXf3sG8JiIxEdCTx4'
        dockerImage = ''
    }**/

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
                     sh  'mvn clean '
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
                        sh 'mvn deploy:deploy-file -DgroupId=com.esprit.examen -DartifactId=tpAchatProject -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://192.168.1.186:8081/repository/maven-releases -Dfile=target/docker-spring-boot.jar'
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

                        /* stage('Building our image') {
                                             steps {

                                                   sh 'docker build -t faroukhajjej1/projet-devops'
                                               }
                                           }


                                             stage('Docker login') {
                                                          steps {
                                                                    sh 'echo "login Docker ...."'
                                                                    sh 'docker login -u faroukhajjej1 -p Fh97213990'
                                                          }
                                                    }
                                                       stage('Docker push') {
                                                                   steps {

                                                                            sh 'echo "Docker is pushing ...."'
                                                                            sh 'docker push faroukhajjej1/projet-devops:156 '
                                                                   }
                                                             }*/






}
}