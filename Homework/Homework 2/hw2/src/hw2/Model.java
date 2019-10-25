package hw2;

import java.util.Stack;

public class Model {
    private Stack<Shape> points;
    private Stack<Shape> pointsRemoved;
    private Shape temp;
    private static String flag = "";
    
    public Model()
    {
        points = new Stack<Shape>();
        pointsRemoved = new Stack<Shape>();
    }
    public void addPoint(Shape shape)
    {
        points.push(shape);
    }
    public void removePoint()
    {
        temp = points.pop();
        pointsRemoved.push(temp);
    }
    public void getPoint(int i)
    {
        points.get(i);
    }
    public Stack<Shape> getPoints()
    {
         return points;
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
