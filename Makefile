.PHONY: all compile

all:
	javac -d . *.java
	java Shapes.Main
