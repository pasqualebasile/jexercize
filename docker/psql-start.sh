#!/bin/bash
# Postgres Docker 
# https://hub.docker.com/_/postgres
# basepath="/home/paskal/studio/dida/postgresql/"
BASEPATH=$(dirname $(realpath "$0"))

docker start psql || docker run -d --name psql -p 5432:5432 \
  -e  POSTGRES_PASSWORD=postgres \
  -v  $BASEPATH/pgdata:/var/lib/postgresql/data:rw \
  postgres:12-alpine

