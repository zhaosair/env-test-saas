## 本地构建

### 准备 maven ${HOME}/.m2/settings.xml
```shell
cp ./m2/settings.xml ${HOME}/.m2/settings.xml
# cp ./m2/settings.xml ~/.m2/settings.xml
```

### 执行构建
> 或通过编辑器 (Intellij Idea) 调试
```shell
mvn package
```

## 容器构建

### 构建
> 先进入目录 ./Docker
```shell
DOCKER_BUILDKIT=1 COMPOSE_DOCKER_CLI_BUILD=1 docker-compose build
```

### 运行
> 运行成功后，可以在浏览器访问api文档 
> http://localhost:8080/swagger-ui.html

```shell
docker-compose up
# docker-compose run api
```


## zero-json使用

### 在新项目中使用
推荐直接使用 cli [zero-json](https://github.com/kequandian/zero-json) 工具来初始化一个新的项目，这样就无需进行上面的引用步骤

### 安装
``` shell
git clone git@github.com:kequandian/zero-json.git
npm install 
npm link
```

### 使用
然后在项目下新建一个json配置文件:

 - [json](json.md)

``` 
例如 config.json
```

然后通过gen-web.sh一个后台管理项目

``` 
例如执行命令 sh gen-web.sh
```

启动后台管理项目

``` 
npm start
```