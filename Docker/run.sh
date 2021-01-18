#!/usr/bin/env bash
## Java JDK 8 +U131 Solution
#  -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap
# JAVA_OPTIONS="Xms300m"

# RUN_OPT= [produce, greenfield, test]
run_opt=$1
if [ ! $run_opt ];then
   run_opt='produce'
fi

webapps=/webapps

## copy config logback-spring.xml
if [ ! -d "$webapps/config" ];then
   mkdir -p "$webapps/config"
fi

if [ ! -f "$webapps/config/logback-spring.xml" ];then
   if [ -f /tmp/logback-spring.xml ];then
      cp /tmp/logback-spring.xml $webapps/config
   fi
fi

## produce config yml
if [ ! -f "$webapps/config/application.yml" ];then
   if [ -f /tmp/produce.yml ];then
      cp /tmp/produce.yml $webapps/config/application.yml
   fi
fi

## test config yml
if [ ! -f "$webapps/config/application-test.yml" ];then
   if [ -f /tmp/test.yml ];then
      cp /tmp/test.yml $webapps/config/application-test.yml
   fi
fi

## greenfield config yml
if [ ${GREENFIELD} ];then
   if [ ! -f "$webapps/config/application-greenfield.yml" ];then
      if [ -f /tmp/greenfield.yml ];then
         cp /tmp/greenfield.yml $webapps/config/application-greenfield.yml
      fi
   fi
   sed -i "s@jdbc:mysql:\/\/\S*?@jdbc:mysql:\/\/${GREENFIELD}?@" $webapps/config/application-greenfield.yml
else
   ## ensure to remove greenfield
   if [ -f "$webapps/config/application-greenfield.yml" ];then
      rm -f  $webapps/config/application-greenfield.yml
   fi
fi


## deploy
if [ ! -f "$webapps/deploy.sh" ];then
   if [ -f /usr/local/bin/deploy.sh ];then
      cp /usr/local/bin/deploy.sh $webapps
   fi
fi
if [ ! -f "$webapps/predeploy.sh" ];then
   if [ -f /usr/local/bin/predeploy.sh ];then
      cp /usr/local/bin/predeploy.sh $webapps
   fi
fi
## deploy lib
if [ ! -f "$webapps/docker-deploy-lib.sh" ];then
   if [ -f /usr/local/bin/docker-deploy-lib.sh ];then
      cp /usr/local/bin/docker-deploy-lib.sh $webapps
   fi
fi


## debug tools
if [ ! -f "$webapps/cfr-0.15.0.jar" ];then
   if [ -f /tmp/cfr-0.15.0.jar ];then
      cp /tmp/cfr-0.15.0.jar $webapps
   fi
fi
if [ ! -f "$webapps/dependency.jar" ];then
   if [ -f /tmp/dependency.jar ];then
      cp /tmp/dependency.jar $webapps
   fi
fi
if [ ! -f "$webapps/mysql-test.jar" ];then
   if [ -f /tmp/mysql-test.jar ];then
      cp /tmp/mysql-test.jar $webapps
   fi
fi



## always running as produce
running=produce

## run app
runapp=''
cd $webapps
if [ ! $runapp ];then
   ## only one app, assign 8080 port for it.
   for app in $(ls app.jar *-standalone.jar -t)
   do
      runapp=$app
   done
   
   ## check lib
   #bash /usr/local/bin/standalone_lib.sh $runapp $newlib
   #rm $newlib  ## just rm it for later update

   ## check exists
   if [ $runapp ];then
      if [ -e $runapp ];then
         if [ $run_opt = 'produce' ];then
            echo "java -jar $runapp --spring.profiles.active=produce --server.port=8080"
            java -jar $runapp --spring.profiles.active=produce --server.port=8080
         elif [ $run_opt = 'test' ];then
            echo "java -jar $runapp --spring.profiles.active=test --server.port=8080"
            java -jar $runapp --spring.profiles.active=test --server.port=8080
         elif [ $run_opt = 'greenfield' ];then
            echo "java -jar $runapp --spring.profiles.active=greenfield --server.port=8080"
            java -jar $runapp --spring.profiles.active=greenfield --server.port=8080
         else 
            echo "java -jar $runapp --spring.profiles.active=produce --server.port=8080"
            java -jar $runapp --spring.profiles.active=produce --server.port=8080
         fi
      fi
   fi
fi


## ignore below command lines
#if [ $running = "produce" ];then
#   ## start other endpoint
#   for ep in $(find . -name "*.jar")
#   do
#      wd=$(dirname $ep)
#      if [ $wd = "." -o $wd = "./" ];then
#          continue;
#      fi
#
#      cd $wd
#      ep=$(basename $ep)
#
#      ## start each endpoint
#      if [ ${GREENFIELD} ];then
#         echo "java -jar $ep --spring.profiles.active=greenfield"
#         java -jar $ep --spring.profiles.active=greenfield
#      else
#         #echo "nohup java  $JAVA_OPTIONS  -jar $ep --spring.profiles.active=produce > /dev/null 2>&1 &"
#         #nohup java $JAVA_OPTIONS -jar $ep --spring.profiles.active=produce > /dev/null 2>&1 & 
#         echo "java $JAVA_OPTIONS -jar $ep --spring.profiles.active=produce"
#         java $JAVA_OPTIONS -jar $ep --spring.profiles.active=produce
#      fi
#
#      ## go back
#      cd $webapps
#   done
#fi


#daemon off
#ln -s /var/www/html /dist
/usr/sbin/nginx "-g" "daemon off;"
