node {
    def app

    stage('Clone repository') {
        /* Let's make sure we have the repository cloned to our workspace */

        checkout scm
    }

    stage('Build image') {
        /* This builds the actual image; synonymous to
         * docker build on the command line */

        app = docker.build("johnybravo/rest_api_automation")
    }

    stage('Create containter') {
        app.run('-v random_volume_name:/home/gradle/home')
    }

    stage('echo') {
        sh 'echo ${WORKSPACE}'
    }
}