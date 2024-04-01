#!/bin/bash
# MongoDb Community Docker 
#
BASEPATH=$(dirname $(realpath "$0"))

docker start mongo || docker run --name mongo -p 27017:27017 \
  -e MONGO_INITDB_ROOT_USERNAME=admin \
  -e MONGO_INITDB_ROOT_PASSWORD=mongo \
  -v  $BASEPATH/mongo:/data/db:rw \
   mongodb/mongodb-community-server

