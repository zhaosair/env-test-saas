#!/bin/sh

## docker build
gitsh=$(which git)

if [ ! $ gitsh ];then
   yum -y install git
fi

git clone git@github.com:zhaosair/env-test-saas.git

cd env-test-saas
cd deploy

## buildkit
COMPOSE_DOCKER_CLI_BUILD=1 docker-compose build api

docker-compose run up $@  ## can add -d
