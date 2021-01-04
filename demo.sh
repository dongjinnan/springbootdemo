#!/usr/bin/env bash
app_name='demo'
docker stop ${app_name}
echo '----------stop container---------'
docker rm ${app_name}
echo '----------rm container---------'
docker run -p 8088:8088 --name ${app_name} \
-v /etc/localtime:/etc/localtime \
-v /devops/app/${app_name}/logs:/var/logs \
-d demo/${app_name}:1.0-SNAPSHOT
echo '----------start container---------'