package hw4;

import java.util.Stack;

public class Controller
{
    private Stack<Shape> shapes;
    private static String flag = "";
    public Controller()
    {
        shapes = new Stack<Shape>();
    }
    public void addShape(Shape shape)
    {
        shapes.push(shape);
    }
    public void getShape(int i)
    {
        shapes.get(i);
    }
    public Stack<Shape> getShapes()
    {
         return shapes;
    }
    public void setFlag(String newFlag)
    {
        flag = newFlag;
    }
    public String getFlag()
    {
        return flag;
    }
}
