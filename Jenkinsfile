pipeline {

    agent any

    tools{
        maven 'Maven'
    }

    stages{
        stage('TestRunner'){
            steps{
                bat 'mvn clean verify'
            }

        }
    }

}