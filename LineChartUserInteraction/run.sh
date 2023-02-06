cd `dirname $0`

export CLASSPATH=$CLASSPATH:./libs/JChart.jar
mkdir ./bin
javac -d ./bin ./src/*.java
cd bin
java -cp ./:./../libs/JChart.jar MainWindow
cd ..
echo “Done”