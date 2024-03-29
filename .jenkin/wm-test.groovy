pipeline {
    agent any
    
    environment {
        // DOCKER_REGISTRY_CREDENTIALS = credentials('docker-hub-credentials')
        GITHUB_CREDENTIALS = credentials('github-credentials')
        DOCKER_IMAGE = 'taaesan/shortest-path-app'
        TAG = ''
    }
    
    stages {
        stage('Checkout') {
            steps {
                script {
                    checkout([$class: 'GitSCM', 
                              branches: [[name: 'main']], 
                              userRemoteConfigs: [[url: 'https://github.com/2024-taaesan-lab/wm-test.git']]])
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
