## About compilation ##
### Level 1 (without libs) ###
#### go to /java/level_1/simple ####
javac Hello.java\
java Hello
#### go to /java/level_1/package ####
javac .\ua\com\alevel\Hello.java\
java ua.com.alevel.Hello
#### go to /java/level_1/separate_packages ####
javac .\ua\com\alevel\Hello.java\
java ua.com.alevel.Hello
#### go to /java/level_1/minimal_proj ####
javac -sourcepath ./src -d build/classes src/ua/com/alevel/Hello.j
ava\
java -cp build/classes ua.com.alevel.Hello
#### go to /java/level_1/med_proj ####
javac -sourcepath ./src -d build/classes .\src\ua\com\alevel\Hello.jav
a\
jar cvfm build/jar/hello.jar resources\MANIFEST.MF -C .\build\classes
.
java -jar build\jar\hello.jar