pipeline {
  agent any
  stages {
    stage('git') {
      steps {
        git(url: 'https://github.com/2024-taaesan-lab/wm-test', branch: 'main', credentialsId: 'git-test-key')
      }
    }

  }
}