# FROM zelejs/allin-web:alpine-m2 as M2
# #build-stage
# FROM zelejs/allin-web:maven-jdk11 as builder
# COPY --from=M2 /root/.m2 /root/.2
FROM zelejs/allin-web:alpine-m2 AS M2

#builk-stage
FROM maven:3.6.0-jdk-11-slim AS build

# init .m2 from alpine-m2 image first
WORKDIR /root/m2
COPY --from=M2 /root/.m2 /root/m2
RUN --mount=type=cache,id=m2_cache,target=/root/.m2,rw cp -r /root/m2/* /root/.m2

## mvn package
WORKDIR /usr/src/app


### Start build
###
COPY ./pom.xml  ./pom.xml
RUN --mount=type=cache,id=m2_cache,target=/root/.m2,rw mvn dependency:go-offline -Dmaven.main.skip=true -Dmaven.test.skip=true
# #RUN --mount=type=bind,source=./.m2,target=/root/.m2,rw mvn -o install

# # To package the application
COPY ./src ./src
RUN --mount=type=cache,id=m2_cache,target=/root/.m2,rw mvn package -Dmaven.test.skip=true
###
### End built



#final-stage
FROM zelejs/app-openjre11:alpine-slim
COPY --from=build /usr/src/app/target/env-test-saas-1.0.0-standalone.jar /webapps/app.jar
ADD ./deploy/config/application.yml /webapps/config/application.yml
