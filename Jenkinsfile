/* node {
    def app

    stage('Clone repository') {
         *//* Let's make sure we have the repository cloned to our workspace *//*

        checkout scm
    }

    stage('Build image') {
         *//* This builds the actual image; synonymous to
         * docker build on the command line *//*

        app = docker.build("johnybravo/rest_api_automation")
    }

    stage('Create container') {
        app.run('-v random_volume_name:/home/gradle/home')
    }

    stage('copying builds') {
        sh 'cp -rf /var/lib/docker/volumes/random_volume_name/_data/ApiAutomation/build ${WORKSPACE}'
    }

    stage('allure-report') {
        allure includeProperties: false, jdk: '', report: 'build/allure-report', results: [[path: 'build/allure-results']]
    }
} */

pipeline {
    agent any
    def app

    stages {
        stage('Clone repository') {
            steps {
                checkout scm
            }
        }
        stage('Build image') {
            steps {
                app = docker.build("johnybravo/rest_api_automation")
            }
        }
        stage('Create container') {
            steps {
                app.run('-v random_volume_name:/home/gradle/home')
            }
        }
        stage('Copy builds') {
            steps {
                def loc
                loc = sh 'sudo docker volume inspect --format "{{ .Mountpoint }}" jenkins_volume '
                sh 'cp -rf ${loc}/ApiAutomation/build ${WORKSPACE}'
            }
        }
        stage('Generate allure report') {
            steps {
                allure includeProperties: false, jdk: '', report: 'build/allure-report', results: [[path: 'build/allure-results']]
            }
        }
    }
}