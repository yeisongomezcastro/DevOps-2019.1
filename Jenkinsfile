pipeline {

    agent any

    stages {
          stage ('Unit Tests') {
		  parallel {
		stage('test'){
			steps {
			echo '------------>test<------------'
			sh './gradlew --stacktrace test'
			}
		}
	    }
        }

        stage ('SonarCloud Static Code Analysis') {
           steps{
		 def scannerHome = tool 'SonarScanner 4.0';
    		withSonarQubeEnv('sonarQube') { 
      		sh "./gradlew ${scannerHome}/bin/sonar-scanner"
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
