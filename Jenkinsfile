node {
    def app

    stage('Clone repository') {
        checkout scm
    }
    stage('Build image and create container') {
        app = docker.build("johnybravo/rest_api_automation")
        //app.run('-v api_automation_volume:/home/ApiAutomation')
        //sh "docker-compose up"
        sh "docker run -v api_automation_volume:/home/ApiAutomation johnybravo/rest_api_automation"
        def build_location = sh (script: 'docker volume inspect --format "{{ .Mountpoint }}" api_automation_volume',returnStdout: true).trim()
        build_location = build_location + "/build"
        sh "cp -rf ${build_location} ${WORKSPACE}"
    }
    /* stage('Create container') {
        app.run('-v api_automation_volume:/home/ApiAutomation')
    } */
    // stage('Clean Workspace') {
      //  sh ' ls ${WORKSPACE}'
        //sh 'rm -rf ${WORKSPACE} *//*'
    //}
    /* stage('Copy build') {
        def build_location = sh (script: 'docker volume inspect --format "{{ .Mountpoint }}" api_automation_volume',returnStdout: true).trim()
        build_location = build_location + "/build"
        sh "cp -rf ${build_location} ${WORKSPACE}"
    } */
    stage('Generate allure report') {
        allure includeProperties: false, jdk: '', report: 'allure-report', results: [[path: 'allure-results']]
    }
    // stage('Remove allure results') {

    //}
}

//def app
/*
pipeline {
    agent any

    stages {
        stage('Clone repository') {
            steps {
                checkout scm
            }
        }
        stage('Build image') {
            steps {
                script {
                    docker.build("johnybravo/rest_api_automation").run('-v api_automation_volume:/home/ApiAutomation')
                }
                //app.run('-v api_automation_volume:/home/ApiAutomation')
            }
            steps {
                script {
                    def build_location = sh (script: 'docker volume inspect --format "{{ .Mountpoint }}" api_automation_volume',returnStdout: true).trim()
                    build_location = build_location + "/build"
                    sh "cp -rf ${build_location} ${WORKSPACE}"
                }
            }
        }
         */
/* stage('Create/Run container') {
            steps {
                app.run('-v api_automation_volume:/home/ApiAutomation')
            }
        } *//*

         */
/* stage('Copy build') {
            steps {
                script {
                    def build_location = sh (script: 'docker volume inspect --format "{{ .Mountpoint }}" api_automation_volume',returnStdout: true).trim()
                    build_location = build_location + "/build"
                    sh "cp -rf ${build_location} ${WORKSPACE}"
                }
            }
        } *//*

        stage('Generate allure report') {
            steps {
                allure includeProperties: false, jdk: '', report: 'allure-report', results: [[path: 'allure-results']]
            }
        }
    }
} */
