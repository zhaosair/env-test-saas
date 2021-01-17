# FROM zelejs/allin-web:alpine-m2 as M2
# #build-stage
# FROM zelejs/allin-web:maven-jdk11 as builder
# COPY --from=M2 /root/.m2 /root/.2
FROM zelejs/allin-web:maven-m2 AS settings

#builk-stage
FROM maven:3.6.0-jdk-11-slim AS build
#should not be /root/.m2, which will be overrided by BUILDKIT --mount=type=bind
COPY --from=settings /root/.m2/settings.xml  /root/settings.xml  

WORKDIR /usr/src/app

COPY ./pom.xml  ./pom.xml
RUN --mount=type=cache,id=m2_cache,target=/root/.m2,rw mvn -s /root/settings.xml dependency:go-offline -Dmaven.main.skip=true -Dmaven.test.skip=true
# #RUN --mount=type=bind,source=./.m2,target=/root/.m2,rw mvn -o install


# # To package the application
COPY ./src ./src
RUN --mount=type=cache,id=m2_cache,target=/root/.m2,rw mvn -s /root/settings.xml package -Dmaven.test.skip=true

#final-stage
FROM zelejs/app-openjre11:alpine-slim
COPY --from=build /usr/src/app/target/env-test-saas-1.0.0-standalone.jar /webapps/app.jar
