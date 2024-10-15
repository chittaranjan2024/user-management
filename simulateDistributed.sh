#!/usr/bin/env bash

# clean desk - clean mind
mvn clean
rm -rf exportJacoco/

# github runner A
mvn '-Dtest=!*IntegrationTest' verify -Djacoco.destFile=exportJacoco/jacoco-fast.exec

# github runner B
mvn '-Dtest=*IntegrationTest' verify -Djacoco.destFile=exportJacoco/jacoco-slow-it.exec

# simulates clean runner C dependent on B and A
rm -rf target/
mkdir target/

# download Github Artifacts ;)
cp exportJacoco/*.exec target/

mvn jacoco:merge package jacoco:report verify -DskipTests=true

# satisfactory observations...
open target/site/jacoco/index.html
