#!/bin/bash
# 先判断文件是否存在，如果存在，则备份
file="/www/server/workspace/autumn-0.0.1-SNAPSHOT.jar"
if [ -f "$file" ]
then
   mv /devops/workspace/demo-0.0.1-SNAPSHOT.jar.`date +%Y%m%d%H%M%S`
fi
mv /root/.jenkins/workspace/demo/target/demo-0.0.1-SNAPSHOT.jar /devops/workspace/demo-0.0.1-SNAPSHOT.jar