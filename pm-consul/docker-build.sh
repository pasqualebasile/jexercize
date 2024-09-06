#!/usr/bin/bash
# Build all docker images of project
cd account-service
./appbuild.sh
cd ..
cd customer-service
./appbuild.sh
cd ..
cd gateway-service
./appbuild.sh
cd ..
cd order-service
./appbuild.sh
cd ..
cd product-service
./appbuild.sh

