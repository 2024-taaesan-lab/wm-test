pipeline {
    agent any

    options {  }
    
    environment {
        // DOCKER_REGISTRY_CREDENTIALS = credentials('docker-hub-credentials')
        GITHUB_CREDENTIALS = credentials('ssh-credential')
        DOCKER_IMAGE = 'taaesan/shortest-path-app'
        TAG = ''
    }
    
    stages {
        stage('Checkout') {
            steps {
                script {
                        git branch: 'main',
                        credentialsId: 'ssh-credential',
                        url: 'git@github.com:2024-taaesan-lab/wm-test.git'                
                    TAG = getLatestTag()
                }
                echo "TAG: ${TAG}"
            }
        }
        
        stage('Build and Package') {
            steps {
                sh "mvn package -f shortest-path-app/pom.xml -Dmaven.test.skip=true"
            }
        }
        
    }
}

def getLatestTag() {
    def tags = sh(script: 'git tag --sort=-creatordate', returnStdout: true).trim()
    def latestTag = tags.tokenize("\n")[0]
    return latestTag
}
