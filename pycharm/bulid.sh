#!/bin/bash

set -e
BASEPATH=$(cd "$(dirname $0)"; pwd)

echo $BASEPATH

ls
#gradle --no-daemon
#echo "start clean"
#gradle clean
#echo "end clean"
#gradle wrapper
#:wrapper

echo "start download gradle.zip"
wget https://tools.mindspore.cn/libs/ide_plugin_dependencies/pycharm/gradle.zip
echo "end download gradle.zip"

ls

echo "start unzip gradle.zip"
tar xvf gradle.zip
echo "end unzip gradle.zip"

ls

chmod +x gradlew

echo "start buildPlugin"
./gradlew buildPlugin --debug
echo "end buildPlugin"

#echo "start spotbugsMain"
#gradle spotbugsMain
#echo "end spotbugsMain"

mkdir output
mv $BASEPATH/build/distributions/* $BASEPATH/output/
cd $BASEPATH/output

for file in ./*
do
  #echo ${file}
  #echo ${file%}.md5
  sha256sum -b ${file} > ${file}.sha256
done
