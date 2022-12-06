## About compilation ##
### Level 1 (without libs) ###
#### go to /java/level_1/simple ####
javac Hi.java\
java Hi
#### go to /java/level_1/package ####
javac .\ua\com\illia\Hi.java\
java ua.com.illia.Hi
#### go to /java/level_1/separate_packages ####
javac .\ua\com\illia\Hello.java\
java ua.com.illia.Hello
#### go to /java/level_1/minimal_proj ####
javac -sourcepath ./src -d build/classes src/ua/com/illia/Hello.j
ava\
java -cp build/classes ua.com.illia.Hello
#### go to /java/level_1/med_proj ####
javac -sourcepath ./src -d build/classes .\src\ua\com\illia\Hello.jav
a\
jar cvfm build/jar/hello.jar resources\MANIFEST.MF -C .\build\classes
.\
java -jar build\jar\hello.jar
### Level 2 (with libs) ###
### Compilation contains external libraries ###
#### go to /java/level_2/include_libs ####

