pipeline {
    agent any
    triggers {
           cron 'H(0-29)/10 * * * *'
        }

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
      
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
//                 git 'https://github.com/Jhalinson/DemoAndroidTesting.git'
//                 echo "WorkSpace {$WORKSPACE}"
                echo 'Hola'
                git branch: 'main', url: 'https://github.com/Jhalinson/DemoAndroidTesting.git'
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: '4d9f07a4-3771-416f-ad95-1bdf60649453', url: 'https://github.com/Jhalinson/DemoAndroidTesting.git']]])
                sh 'mvn clean'
                sh 'mvn compile'
                sh 'mvn test'
                // Run Maven on a Unix agent.
//                 sh "mvn clean"
//                 sh "mvn compile"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

//             post {
//                 // If Maven was able to run the tests, even if some of the test
//                 // failed, record the test results and archive the jar file.
//                 success {
//                     junit '**target/surefire-reports/index.html'
//                     archiveArtifacts 'target/*.jar'
//                 }
//             }
        }
    }
}
