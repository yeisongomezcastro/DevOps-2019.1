pipeline {

    agent any
	environment {
		PROJECT_PATH_BACK = './'
	}

    stages {
          stage ('Unit Tests') {
		  parallel {
		stage('test'){
			steps {
			echo '------------>test<------------'
			dir("${PROJECT_PATH_BACK}")
			sh './gradlew --stacktrace test'
			}
		}
	    }
        }

    
             stage ('SonarCloud Static Code Analysis') {
            steps{
               echo '------------>SonarCloud Static Code Analysis<------------'
               withSonarQubeEnv('sonarQube') {
                   sh './gradlew sonarqube'
               }
           }
       }
        

        stage ('SonarCloud Quality Gate') {
            steps {
                withSonarQubeEnv('sonarQube') {
                    timeout(time: 5, unit: 'MINUTES') {
                        waitForQualityGate abortPipeline: true
                    }
                }
            }
        }

        stage('Build') {
            steps {
                sh './gradlew assemble'
                archiveArtifacts( artifacts: 'build/libs/*.jar', fingerprint: true)
            }
        }
    }
}
