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
    public void addShape(Shape shape)
    {
        shapes.push(shape);
//        shapeRedoList.empty();
        // empty shapeRedoList stack
        while(!shapeRedoList.isEmpty())
            shapeRedoList.pop();
        if(shapeRedoList.isEmpty())
            System.out.println("shapeRedoList stack is empty");
        else
            System.out.println("shapeRedoList stack is still NOT empty");
    }
    public void removeShape()
    {
        if(shapes.isEmpty())
            System.out.println("shapes stack is empty");
        else
        {
            temp = shapes.pop();
            shapeRedoList.push(temp);
            System.out.println("shape removed from shapes stack and added to shapeRedoList stack");
        }
    }
    public void addShapeRedo()
    {
        if(shapeRedoList.isEmpty())
            System.out.println("shapeRedoList stack is empty");
        else
        {
            temp = shapeRedoList.pop();
            shapes.push(temp);
            System.out.println("shape removed from shapeRedoList stack and added to shapes stack");
        }
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
