#!/usr/bin/bash

mvn clean package -DskipTests
docker build -t pm-consul/product-service:latest .