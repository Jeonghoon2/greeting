#!/bin/bash

JAR_FILE_NAME=greeting-0.0.1-SNAPSHOT.jar

# 현재 실행 중인 pid 가져오기
PID=$(pgrep -f $JAR_FILE_NAME)

# 현재 실행중인 process 죽이기
if [ -z "$PID" ]; then
  echo "> 현재 구동중인 애플리케이션이 없으므로 종료하지 않습니다."
else
  echo "> kill -9 $PID"
  kill -9 $PID
  echo "> 실행중인 애플리케이션을 종료하고 있습니다..."
  sleep 10
fi

#다시 시작
echo "> 애플리케이션을 다시 시작합니다..."
nohup java \
    -jar /build/libs/$JAR_FILE_NAME &
echo "> 애플리케이션이 백그라운드에서 실행 중입니다."
