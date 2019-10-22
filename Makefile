.PHONY: all compile

all:
	javac -d . *.java
	java -Dswing.aatext=true -Dawt.useSystemAAFontSettings=on lab2.Main
