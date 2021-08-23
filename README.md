## 一键部署
```
echo '151.101.64.133 raw.githubusercontent.com' >> /etc/hosts
```
```
curl -sL https://raw.githubusercontent.com/zhaosair/env-test-saas/master/cli/docker-prod-run.sh | bash -
```


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
> 先进入目录 ./Docker

#### 基于源代码直接构建
```shell
COMPOSE_DOCKER_CLI_BUILD=1 docker-compose build api
```

#### 本地构建后，可省去代码构建过程》 
> 已在本地构建，没有代码构建过程，无需用缓存，可省去 `COMPOSE_DOCKER_CLI_BUILD=1`
```shell
docker-compose build local
```


### 运行
> 进入 ./Docker 运行
```shell
docker-compose up api
```
>
> 直接在根目录`./` 运行，无容器构建
```shell
docker-compose up
```
>
> 运行成功后，可以在浏览器访问api文档 
>
> http://localhost:8080/swagger-ui.html


## 生产环境
> 进入 ./deploy 构建生产环境 image
```shell
docker-compose build api
```

#### 生产环境部署
> 发布至私服 `192.168.3.100:5000` 为Docker Register服务地址
```
docker tag env-test-saas:latest 192.168.3.100:5000/env-test-saas:latest
docker push 192.168.3.100:5000/env-test-saas:latest
```
> 登录至生产服务器，从私服下拉部署
```
docker pull 192.168.3.100:5000/env-test-saas:latest
docker tag 192.168.3.100:5000/env-test-saas:latest env-test-saas:latest
```
> 在 `config/application.yml` 中配置应用数据库连接
```
cat config/application.yml
```
> 执行
```
docker-compose up -d
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

