pipeline {
    agent any

    environment {
        MAVEN_HOME = tool name: 'Maven 3.6.3', type: 'maven'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build and Test') {
            steps {
                script {
                    sh "${env.MAVEN_HOME}/bin/mvn clean compile test"
                }
            }
        }

        stage('SpotBugs Analysis') {
            steps {
                script {
                    sh "${env.MAVEN_HOME}/bin/mvn spotbugs:check"
                }
            }
        }

        stage('Dependency-Check Analysis') {
            steps {
                script {
                    sh "${env.MAVEN_HOME}/bin/mvn org.owasp:dependency-check-maven:check"
                }
            }
        }
    }

    post {

        success {
            echo 'Build succeeded!'
        }

        failure {
            echo 'Build failed due to Checkstyle, SpotBugs, or Dependency-Check violations.'
        }
    }
}
