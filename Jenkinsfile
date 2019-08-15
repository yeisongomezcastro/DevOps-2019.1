pipeline {

    agent any

    stages {
          stage ('Unit Tests') {
            parallel {
			stage('Test'){
			steps {
			echo '------------>test<------------'
			sh './gradlew --stacktrace test'

			}
		}
	    }
        }

        stage ('SonarCloud Static Code Analysis') {
           steps{
		echo '------------>Static Code Analysis<------------'
 		withSonarQubeEnv('Sonar') {
                     sh "${tool name: 'sonarQube', type: 'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dproject.settings=./sonar-project.properties"
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
