import java.util.Stack;

public class Controller
{
    private Stack<Shape> shapes;
    private Stack<Shape> shapeRedoList;
    private Shape temp;
    private static String flag = "";
    public Controller()
    {
        shapes = new Stack<Shape>();
        shapeRedoList = new Stack<Shape>();
    }
    public void addShape(Shape shape)
    {
        shapes.push(shape);
        // empty shapeRedoList stack
        while(!shapeRedoList.isEmpty())
            shapeRedoList.pop();
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
