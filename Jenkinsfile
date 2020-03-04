pipeline {

    agent any

    tools{
        maven 'Maven'
    }

    stages{
        stage('TestRunner'){
            steps{
                echo 'mvn clean verify'
            }

        }
    }

}