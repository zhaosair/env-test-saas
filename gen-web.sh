#!/usr/bin/bash

#初始化一个后台管理项目web
zero-json manage init web

cp config.json $(pwd)/web/build.json

zero-json manage gen test

mv test $(pwd)/web/src/pages

echo npm install

echo npm start








