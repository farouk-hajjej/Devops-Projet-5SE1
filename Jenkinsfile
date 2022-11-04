pipeline {
    agent any
   environment {
        registry = "montassarslama/projet"
        registryCredential = 'docker'
        dockerImage = ''
    }

    stages {

        stage('Git stage') {

            steps {
                echo "Getting project form github";
                 git branch: 'monta_produit',
                 url : 'https://github.com/farouk-hajjej/Devops-Projet-5SE1.git';

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

        stage('Mockito stage') {

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


    }
}