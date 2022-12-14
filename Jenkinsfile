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
    stage('copying builds') {
        //def loc
        //String loc = sh 'docker volume inspect --format "{{ .Mountpoint }}" random_volume_name'
        def LOC = sh (
                         script: 'docker volume inspect --format "{{ .Mountpoint }}" random_volume_name',
                         returnStdout: true
                     ).trim()
        //String loc = sh 'docker volume inspect --format "{{ .Mountpoint }}" random_volume_name | sed "s/$/\/ApiAutomation\/build/" | xargs cp -rft ${WORKSPACE}'
        println(WORKSPACE)
        LOC = LOC + "/ApiAutomation/build"
        println(LOC)
        sh 'echo ${LOC}'
        sh 'echo ${WORKSPACE}'
        //sh 'echo ${loc}'
        //sh 'cp -rf ${loc}/ApiAutomation/build ${WORKSPACE}'
        //sh 'cp -rf /var/lib/docker/volumes/random_volume_name/_data/ApiAutomation/build ${WORKSPACE}'
    }
    stage('allure-report') {
        allure includeProperties: false, jdk: '', report: 'build/allure-report', results: [[path: 'build/allure-results']]
    }
}