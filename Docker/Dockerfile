FROM zelejs/app-openjre11:alpine-slim

## COPY ./target/env-test-saas-1.0.0-standalone.jar into ./Docker first
COPY ./env-test-saas-1.0.0-standalone.jar /usr/local/src/app.jar
ADD ./config/application.yml /usr/local/src/config/application.yml
