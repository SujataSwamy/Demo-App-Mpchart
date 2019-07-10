#!/bin/bash








# Firebase service account decrypt
- openssl aes-256-cbc -K $encrypted_783d9be09488_key -iv $encrypted_783d9be09488_iv
  -in travis-ci-demo-4efee-0e9f1d0f0fd2.json.enc -out travis-ci-demo-4efee-0e9f1d0f0fd2.json
  -d


# Firebase setup
wget --quiet --output-document=/tmp/google-cloud-sdk.tar.gz https://dl.google.com/dl/cloudsdk/channels/rapid/google-cloud-sdk.tar.gz  
mkdir -p /opt  
tar zxf /tmp/google-cloud-sdk.tar.gz --directory /opt  
/opt/google-cloud-sdk/install.sh --quiet
source /opt/google-cloud-sdk/path.bash.inc




# Setup and configure the project
gcloud components update  
echo travis-ci-demo-4efee 
gcloud config set project travis-ci-demo-4efee




# Activate cloud credentials
gcloud auth activate-service-account --key-file /tmp/travis-ci-demo-4efee-0e9f1d0f0fd2.json




# List available options for logging purpose only (so that we can review available options)


gcloud firebase test android models list  
gcloud firebase test android versions list

./gradlew build assembleDebug
gcloud firebase test android run --app app/build/outputs/apk/debug/app-debug.apk --type=robo --device model=Nexus4,version=19





