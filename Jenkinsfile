pipeline {

    agent any

    tools{
        maven 'Maven'
    }

    stages{
        stage('TestRunner'){
            steps{
                sh 'mvn clean verify'
            }

        }
    }

}