import java.text.SimpleDateFormat
pipeline {
/**environment {
        registry = "faroukhajjej1/projet-devops"
        registryCredential = 'dckr_pat_I63lpP-WDrsX4CZP1vDIG6NJoKo'
        dockerImage = ''
    }**/

agent any
stages {
    stage('Get Code from GitHub') {
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

    stage(' MVN COMPILE'){
            steps{
                sh  'mvn compile'
            }
     }



    stage('MVN PACKAGE'){
                  steps{
                        sh  'mvn package'
                   }
    }
            /*  stage("Nexus deploy"){
                     steps {
                        sh 'mvn deploy:deploy-file -DgroupId=com.esprit.examen -DartifactId=tpAchatProject -Dversion=2.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://192.168.1.195:8081/repository/maven-releases -Dfile=target/docker-spring-boot.jar'
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
                                           */



                                                     /*  stage('Docker push') {
                                                                   steps {

                                                                            sh 'echo "Docker is pushing ...."'
                                                                            sh 'docker push faroukhajjej1/projet-devops:156 '
                                                                   }
                                                             }*/
       /*   stage('Building our image') {
                              steps {
                                  script {
                                     dockerImage = docker.build registry + ":$BUILD_NUMBER"
                                           }
                                      }
                                      }

                              /* stage('Docker login') {
                                     steps {
                                       sh 'echo "login Docker ...."'
                                       sh 'docker login -u faroukhajjej1 -p Fh97213990'
                                           }
                                                       }*/

     /*   stage('Deploy our image') {
                      steps {
                           script {
                              docker.withRegistry( '', registryCredential ) {
                                        dockerImage.push()
                                           }
                                          }
                                      }
                          }
                 stage('Cleaning up') {
                           steps {
                                 sh "docker rmi $registry:$BUILD_NUMBER"
                                   }
                                }

       stage('DOCKER COMPOSE') {
          steps {
            sh 'docker-compose up -d --build'
        }*/
    }
    }
     /* post {

                    success {
                        mail to: "hajjej.farouk6@gmail.com",
                        body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n, More info at: ${env.BUILD_URL}",
                        from: 'hajjej.farouk6@gmail.com',
                        subject: "Jenkins Build ${currentBuild.currentResult}: Job ${env.JOB_NAME}"
                    }

                    failure{
                        mail to: "hajjej.farouk6@gmail.com",
                        subject: "Jenkins build:${currentBuild.currentResult}: ${env.JOB_NAME}",
                        from: 'hajjej.farouk6@gmail.com',
                        body: "${currentBuild.currentResult}: Job ${env.JOB_NAME}\nMore Info can be found here: ${env.BUILD_URL}"
                    }

                    changed{
                        mail to: "hajjej.farouk6@gmail.com",
                        subject: "Jenkins build:${currentBuild.currentResult}: ${env.JOB_NAME}",
                        from: 'hajjej.farouk6@gmail.com',
                        body: "${currentBuild.currentResult}: Job ${env.JOB_NAME}\nMore Info can be found here: ${env.BUILD_URL}"
                    }
                }*/








