#stop.sh
#!/bin/bash
echo "Stopping SpringBoot Application"
pid=`ps -ef | grep demo-0.0.1-SNAPSHOT.jar | grep -v grep | awk '{print $2}'`
if [ -n "$pid" ]
then
   kill -9 $pid
fi