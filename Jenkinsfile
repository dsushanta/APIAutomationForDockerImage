node {
    def app

    stage('Clone repository') {
        checkout scm
    }
    stage('Build image') {
        app = docker.build("johnybravo/rest_api_automation")
    }
    stage('Create container') {
        app.run('-v random_volume_name:/home/gradle/home')
    }
    stage('Clean Workspace') {
        sh ' ls ${WORKSPACE}'
        sh 'rm -rf ${WORKSPACE}/*'
    }
    stage('Copy build') {
        def build_location = sh (script: 'docker volume inspect --format "{{ .Mountpoint }}" random_volume_name',returnStdout: true).trim()
        build_location = build_location + "/ApiAutomation/build"
        sh "cp -rf ${build_location} ${WORKSPACE}"
    }
    stage('Generate allure report') {
        allure includeProperties: false, jdk: '', report: 'build/allure-report', results: [[path: 'build/allure-results']]
    }
    stage('Remove allure results') {

    }
}