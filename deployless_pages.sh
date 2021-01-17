#!/usr/bin/bash

mod=$1
routerName=$2
routerPath=$3

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



if [ ! $mod -o ! $routerName -o ! $routerPath ];then
   echo 'Usage: deployless <page_name> <route_name> <router_path>'
   echo '  e.g. deployless page_test test t/t'
   exit
fi

if [ ! -d  $mod ];then
   if [ ! -d ../${mod} ];then 
     echo page $mod not exists
     exit
   else
     cd ..
   fi
fi


## deploy page
deploy_page() {
    ## means page, check dist
   if [ ! -d ${mod}/config ];then
      echo you try to deply page, but config not exists
      exit
   fi

   ## package page with tar
   echo tar -cvf ${mod}.tar ${mod} 
   tar -cvf ${mod}.tar ${mod}
   echo scp ${mod}.tar $target/env-web/src/pages
   scp ${mod}.tar $target/env-web/src/pages
   ## clean after scp
   echo rm ${mod}.tar
   rm ${mod}.tar

   echo ssh $ssh_host \"cd $app_path/env-web/src/pages and exec deploy.sh\"
   ssh $ssh_host "cd $app_path/env-web/src/pages && sh deploy.sh $mod $routerName $routerPath"
}

## main  ##

if [ -f ${mod}/index.js ];then
   deploy_page
fi


# done
echo Done


