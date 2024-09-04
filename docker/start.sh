#!/bin/bash
# Postgres Docker 
# https://hub.docker.com/_/postgres
# basepath="/home/paskal/studio/dida/postgresql/"
BASEPATH=$(dirname $(realpath "$0"))

docker run  --name psql -p 5432:5432 \
  -e POSTGRES_PASSWORD=gateway -e POSTGRES_USER=gateway postgres:12-alpine

