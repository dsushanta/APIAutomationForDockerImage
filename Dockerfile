#FROM johnybravo/rest_api_automation_framework:latest
FROM gradle:7.6.0-jdk17-alpine
COPY src /home/ApiAutomation/src
COPY build.gradle /home/ApiAutomation/build.gradle
COPY gradlew /home/ApiAutomation/gradlew
COPY gradle /home/ApiAutomation/gradle
COPY settings.gradle /home/ApiAutomation/settings.gradle
WORKDIR /home/ApiAutomation
ENTRYPOINT gradle clean cucumberCli