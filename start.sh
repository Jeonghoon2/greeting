#!/bin/bash

JAR_FILE_NAME=greeting-0.1.0-SNAPSHOT.jar
JAR_PATH=/path/to/jenkins/workspace/build/libs  # 실제 JAR 파일 경로로 변경

# 실행 중인 애플리케이션의 PID 가져오기
PID=$(pgrep -f $JAR_FILE_NAME)

if [ -z "$PID" ]; then
  echo "> 현재 구동중인 애플리케이션이 없으므로 종료하지 않습니다."
else
  echo "> kill -9 $PID"
  kill -9 $PID
  echo "> 실행중인 애플리케이션을 종료하고 있습니다..."
  sleep 10
fi

# nohup을 사용하여 애플리케이션을 백그라운드에서 실행
echo "> 애플리케이션을 다시 시작합니다..."
nohup java -jar $JAR_PATH/$JAR_FILE_NAME > /dev/null 2>&1 &
echo "> 애플리케이션이 백그라운드에서 실행 중입니다."
