.PHONY: all compile

all:
	javac -d . *.java
	java -Dswing.aatext=true -Dawt.useSystemAAFontSettings=on Shapes.Main
