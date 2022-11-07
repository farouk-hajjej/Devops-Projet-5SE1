import java.text.SimpleDateFormat
pipeline {
    agent any
   environment {
        registry = "montassarslama/devopsproduit"
        registryCredential = 'docker'
        dockerImage = ''
    }

    stages {
    stage('Log Tool Version') {
          parallel {
            stage('Log Tool Version') {
              steps {
                sh '''mvn --version
                      git --version
                      java -version'''
              }
            }

            stage('Check for POM') {
              steps {
                fileExists 'pom.xml'
              }
            }

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

     stage("Email"){
                  steps{
                      emailext attachLog: true, body: "${env.BUILD_URL} has result ${currentBuild.result}", compressLog: true, subject: "Status of pipeline: ${currentBuild.fullDisplayName}", to: 'devopsmonta2022@gmail.com'
                  }
              }
       }
       }

