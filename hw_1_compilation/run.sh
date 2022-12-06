#!/bin/sh

echo 'run level_1'

echo 'run simple'
cd ./java/level_1/simple
javac Hi.java
java Hi

cd ../

echo 'run package'
cd ./package
javac ua/com/illia/Hi.java
java ua.com.illia.Hi

cd ../

echo 'run separate packages'
cd ./separate_packages
javac ua/com/illia/Hello.java
java ua.com.illia.Hello

cd ../

echo 'run minimal proj'
cd ./minimal_proj
javac -sourcepath ./src -d build/classes ./src/ua/com/illia/Hello.java
java -cp build/classes ua.com.illia.Hello

cd ../

echo 'run med proj and create simple jar'
cd ./med_proj
javac -sourcepath ./src -d build/classes ./src/ua/com/illia/Hello.java
jar cvfm build/jar/hello.jar resources/MANIFEST.MF -C build/classes .
java -jar build/jar/hello.jar

cd ../../..

./remove-class.sh









