package hw2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.Stack;
import javax.swing.JPanel;

public class JPanelDraw extends JPanel
{
    private Stack<Shape> shapes;
    private Stack<Shape> shapeRedoList;
    private Shape temp;
    private static String flag = "";
    public JPanelDraw()
    {
        shapes = new Stack<Shape>();
        shapeRedoList = new Stack<Shape>();
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Iterator<Shape> it = shapes.iterator();
        while(it.hasNext())
            it.next().Draw(g2);
    }
    public void drawCircle(MouseEvent e)
    {
        Circle circle = new Circle(e.getX(), e.getY());
//        addShape(circle);
        shapes.push(circle);
        // empty shapeRedoList stack
        while(!shapeRedoList.isEmpty())
            shapeRedoList.pop();
        setFlag("");
        repaint();
}
    public void drawBox(MouseEvent e)
    {
        Box box = new Box(e.getX(), e.getY());
//        addShape(box);
        shapes.push(box);
        // empty shapeRedoList stack
        while(!shapeRedoList.isEmpty())
            shapeRedoList.pop();
        setFlag("");
        repaint();
    }
    public void drawHelloworld(MouseEvent e)
    {
        Helloworld helloworld = new Helloworld(e.getX(), e.getY());
//        addShape(helloworld);
        shapes.push(helloworld);
        // empty shapeRedoList stack
        while(!shapeRedoList.isEmpty())
            shapeRedoList.pop();
        setFlag("");
        repaint();
    }
    public void drawUndo()
    {
        if(!shapes.isEmpty())
        {
            temp = shapes.pop();
            shapeRedoList.push(temp);
        }
        repaint();
    }
    public void drawRedo()
    {
        if(!shapeRedoList.isEmpty())
        {
            temp = shapeRedoList.pop();
            shapes.push(temp);
        }
        repaint();
    }
//    public void addShape(Shape shape)
//    {
//        shapes.push(shape);
//        // empty shapeRedoList stack
//        while(!shapeRedoList.isEmpty())
//            shapeRedoList.pop();
//    }
//    public void removeShape()
//    {
//        if(!shapes.isEmpty())
//        {
//            temp = shapes.pop();
//            shapeRedoList.push(temp);
//        }
//    }
//    public void addShapeRedo()
//    {
//        if(!shapeRedoList.isEmpty())
//        {
//            temp = shapeRedoList.pop();
//            shapes.push(temp);
//        }
//    }
    public void getShape(int i)
    {
        shapes.get(i);
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
