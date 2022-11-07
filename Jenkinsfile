import java.text.SimpleDateFormat
pipeline {
    agent any
   environment {
        registry = "montassarslama/devopsfin"
        registryCredential = 'docker'
        dockerImage = ''
    }

    stages {
        stage('Date') {
             steps {
                script{
                     def date = new Date()
                     sdf = new SimpleDateFormat("MM/dd/yyyy")
                     println(sdf.format(date))
                             }
                             }
                             }


        stage('MVN CLEAN  stage') {

            steps {
            sh 'mvn clean'

            }
        }

        stage('MVN INSTALL stage') {

            steps {
            sh 'mvn install '

            }
        }

		stage('MVN COMPILE  stage') {

            steps {
            sh 'mvn compile'

            }
        }

		stage('MVN PACKAGE  stage') {

            steps {
            sh 'mvn package'

            }
        }



        stage('SonarQube stage') {

            steps {
            sh'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar -e'

            }
        }

        stage('Test JUnit /Mockito stage') {

            steps {
            sh 'mvn test'

            }
        }

           stage('Nexus stage') {

            steps {
           sh 'mvn deploy -e'

            }
        }

        stage('Building our docker image') {
            steps {
                script {
                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }

        stage('Deploy our image to Docker Hub') {
            steps {
                script {
                    docker.withRegistry( '', registryCredential ) {
                        dockerImage.push()
                    }
                }
            }
        }

        stage('docker compose stage') {

            steps {
           sh 'docker-compose up -d'

            }
        }

    /*  stage("Email"){
                  steps{
                      emailext attachLog: true, body: "${env.BUILD_URL} has result ${currentBuild.result}", compressLog: true, subject: "Status of pipeline: ${currentBuild.fullDisplayName}", to: 'montassar.slama@esprit.tn'
                  }
              }
       }
       }*/

        }
             post {

                           success {
                               mail to: "devopsmonta2022@gmail.com",
                               body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n, More info at: ${env.BUILD_URL}",
                               from: 'devopsmonta2022@gmail.com',
                               subject: "Jenkins Build ${currentBuild.currentResult}: Job ${env.JOB_NAME}"
                           }

                           failure{
                               mail to: "devopsmonta2022@gmail.com",
                               subject: "Jenkins build:${currentBuild.currentResult}: ${env.JOB_NAME}",
                               from: 'devopsmonta2022@gmail.com',
                               body: "${currentBuild.currentResult}: Job ${env.JOB_NAME}\nMore Info can be found here: ${env.BUILD_URL}"
                           }

                           changed{
                               mail to: "devopsmonta2022@gmail.com",
                               subject: "Jenkins build:${currentBuild.currentResult}: ${env.JOB_NAME}",
                               from: 'devopsmonta2022@gmail.com',
                               body: "${currentBuild.currentResult}: Job ${env.JOB_NAME}\nMore Info can be found here: ${env.BUILD_URL}"
                           }
                       }








       }