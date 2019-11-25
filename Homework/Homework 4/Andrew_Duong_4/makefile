JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
		$(JC) $(JFLAGS) $*.java

CLASSES = \
		Box.java \
		BoxState.java \
		Circle.java \
		CircleState.java \
		Context.java \
		Controller.java \
		Hw4.java \
		JPanelDraw.java \
		NoShapeState.java \
		Shape.java \
		State.java \
		View.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
		$(RM) *.class