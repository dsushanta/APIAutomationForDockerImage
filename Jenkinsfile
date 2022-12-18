/* node {
    def app

    stage('Clone repository') {
        checkout([$class: 'GitSCM', branches: [[name: '*//* master']], extensions: [[$class: 'CleanBeforeCheckout', deleteUntrackedNestedRepositories: true]], userRemoteConfigs: [[url: 'https://github.com/dsushanta/APIAutomationForDockerImage.git']]])
    }
    stage('Create Docker volume') {
        sh "docker volume create api_automation_volume"
    }
    stage('Build image and create container') {
        app = docker.build("johnybravo/rest_api_automation")
        //app.run('-v api_automation_volume:/home/ApiAutomation')
        //sh "docker-compose up"
        sh "docker run --name api_automation_container -v api_automation_volume:/home/ApiAutomation johnybravo/rest_api_automation"
        def build_location = sh (script: 'docker volume inspect --format "{{ .Mountpoint }}" api_automation_volume',returnStdout: true).trim()
        build_location = build_location + "/allure-results"
        sh "cp -rf ${build_location} ${WORKSPACE}"
    }
     *//* stage('Create container') {
        app.run('-v api_automation_volume:/home/ApiAutomation')
    } *//*
    // stage('Clean Workspace') {
      //  sh ' ls ${WORKSPACE}'
        //sh 'rm -rf ${WORKSPACE} *//*  *//*'
    //}
     *//* stage('Copy build') {
        def build_location = sh (script: 'docker volume inspect --format "{{ .Mountpoint }}" api_automation_volume',returnStdout: true).trim()
        build_location = build_location + "/build"
        sh "cp -rf ${build_location} ${WORKSPACE}"
    } *//*
    stage('Generate allure report') {
        allure includeProperties: false, jdk: '', report: 'allure-report', results: [[path: 'allure-results']]
    }
    stage('Clean up') {
        sh "rm -rf ${WORKSPACE} *//*"
        sh 'docker rm -f $(docker ps -aq)'
        sh 'docker rmi johnybravo/rest_api_automation'
        sh "docker volume rm api_automation_volume"
    }
    // stage('Remove allure results') {

    //}
} */


pipeline {
    agent any

    stages {
        stage('Clone repository') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [[$class: 'CleanBeforeCheckout', deleteUntrackedNestedRepositories: true]], userRemoteConfigs: [[url: 'https://github.com/dsushanta/APIAutomationForDockerImage.git']]])
            }
        }
        stage('Create Docker volume') {
            steps {
                script {
                    sh "docker volume create api_automation_volume"
                }
            }
        }
        stage('Build image') {
            steps {
                script {
                    docker.build("johnybravo/rest_api_automation")
                }
            }
        }
        stage('Create/Run container') {
            steps {
                script {
                    sh "docker run --name api_automation_container -v api_automation_volume:/home/ApiAutomation johnybravo/rest_api_automation"
                    //def build_location = sh (script: 'docker volume inspect --format "{{ .Mountpoint }}" api_automation_volume',returnStdout: true).trim()
                    //build_location = build_location + "/allure-results"
                    //sh "cp -rf ${build_location} ${WORKSPACE}"
                }
            }
        }
        stage('Generate allure report') {
            steps {
               script {
                    def build_location = sh (script: 'docker volume inspect --format "{{ .Mountpoint }}" api_automation_volume',returnStdout: true).trim()
                    build_location = build_location + "/allure-results"
                    sh "cp -rf ${build_location} ${WORKSPACE}"
                }
                allure includeProperties: false, jdk: '', report: 'allure-report', results: [[path: 'allure-results']]
            }
        }
        /* stage('Clean up') {
            steps {
                script {
                    sh "rm -rf ${WORKSPACE} *//*"
                    sh 'docker rm -f $(docker ps -aq)'
                    sh 'docker rmi johnybravo/rest_api_automation'
                    sh "docker volume rm api_automation_volume"
                }
            }
        } */
    }
    post {
        always {
            script {
                sh "rm -rf ${WORKSPACE}/*"
                sh 'docker rm -f $(docker ps -aq)'
                sh 'docker rmi johnybravo/rest_api_automation'
                sh "docker volume rm api_automation_volume"
            }
        }
    }
}