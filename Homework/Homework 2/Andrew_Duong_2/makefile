JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
		$(JC) $(JFLAGS) $*.java

CLASSES = \
		Box.java \
		Circle.java \
		Controller.java \
		Helloworld.java \
		Hw2.java \
		JPanelDraw.java \
		Shape.java \
		View.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
		$(RM) *.class