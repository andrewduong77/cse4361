package hw4;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.Stack;
import javax.swing.JPanel;

public class JPanelDraw extends JPanel
{
    private Stack<Shape> shapes;
    public JPanelDraw()
    {
        shapes = new Stack<Shape>();
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
        shapes.push(circle);
        repaint();
    }
    public void drawBox(MouseEvent e)
    {
        Box box = new Box(e.getX(), e.getY());
        shapes.push(box);
        repaint();
    }
}
