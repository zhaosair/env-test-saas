#!/usr/bin/bash

mod=$1

## host ##
#target='ems@mall.smallsaas.cn:/home/ems/am'
target='root@dev.svcpaas.smallsaas.cn:/root/dev/'
#### split from target  below ###
app_path=${target##*:}  ## cur before :
ssh_host=${target%%:*}
####


## debug
echo ssh_host= $ssh_host
echo app_path= $app_path
#exit
## end debug



if [ ! $mod ];then
   echo 'Usage: deployless <module>'
   echo '  e.g. deployless env-fault'
   exit
fi

if [ ! -d  $mod ];then
   if [ ! -d ../$mod ];then 
     echo module $mod not exists
     exit
   else
     cd ..
   fi
fi


## deploy web
deploy_web() {
    ## means web, check dist
   if [ ! -d dist ];then
      echo you try to deply web, but dist not exists
      exit
   fi

   ## package dist with tar
   echo tar -cvf dist.tar dist 
   tar -cvf dist.tar dist
   echo scp dist.tar $target/web
   scp dist.tar $target/web
   ## clean after scp
   echo rm dist.tar
   rm dist.tar

   echo ssh $ssh_host \"cd $app_path/web && sh deploy.sh\"
   ssh $ssh_host "cd $app_path/web && sh deploy.sh"
}

## deploy lib
deploy_lib() {
  list=()
  for jar in $(ls target/*.jar);do
     if [ $jar == target/*standalone.jar ];then
        echo $jar >/dev/null
     else
       list="$list $jar"
     fi
  done

  echo scp $list ${target}/env-api/lib
  scp $list ${target}/env-api/lib
  echo ssh $ssh_host \"cd $app_path/env-api exec sh docker-deploy-lib.sh\"
  ssh $ssh_host "cd $app_path/env-api && sh docker-deploy-lib.sh"
}


## main  ##
cd $mod  ## go into module

if [ -f package.json ];then
   deploy_web
else
   deploy_lib
fi


# done
echo Done


