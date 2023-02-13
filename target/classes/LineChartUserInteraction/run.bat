set CLASSPATH=%CLASSPATH%;libs\JChart.jar
md bin
javac -d bin src/*.java
cd bin
java -cp ./;..\libs\JChart.jar MainWindow
cd..
pause..