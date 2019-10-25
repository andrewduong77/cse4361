package hw2;

import java.util.Stack;

public class Model {
    private Stack<Shape> shapes;
    private Stack<Shape> shapeRedoList;
    private Shape temp;
    private static String flag = "";
    
    public Model()
    {
        shapes = new Stack<Shape>();
        shapeRedoList = new Stack<Shape>();
    }
    public void addPoint(Shape shape)
    {
        shapes.push(shape);
    }
    public void removePoint()
    {
        if(shapes.isEmpty())
            System.out.println("points stack is empty");
        else
        {
            temp = shapes.pop();
            shapeRedoList.push(temp);
            System.out.println("shape removed from stack and added to shapeRedoList");
        }
    }
    public void getPoint(int i)
    {
        shapes.get(i);
    }
    public Stack<Shape> getPoints()
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
