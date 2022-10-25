pipeline {
    agent any

    stages {


        stage('Git') {
            steps {
                echo "Getting Project from Git";
                git "https://github.com/farouk-hajjej/Devops-Projet-5SE1.git";
            }
        }

        stage('COMPILING') {
            steps {
                sh 'mvn compile'
            }
        }


        stage('SONARQUBE') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
            }
        }



        stage('JUNIT -MOCKITO') {
            steps {
                echo 'Hello World'
            }
        }



        stage('NEXUS') {
            steps {
                sh 'mvn deploy -DskipTests'
            }
        }


    }
}
