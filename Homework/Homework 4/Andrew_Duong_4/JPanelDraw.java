package hw2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import javax.swing.JPanel;

public class JPanelDraw extends JPanel
{
    private Controller controller = new Controller();
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Iterator<Shape> it = controller.getShapes().iterator();
        while(it.hasNext())
            it.next().Draw(g2);
    }
    public void drawCircle(MouseEvent e)
    {
        Circle circle = new Circle(e.getX(), e.getY());
        controller.addShape(circle);
        controller.setFlag("");
        repaint();
}
    public void drawBox(MouseEvent e)
    {
        Box box = new Box(e.getX(), e.getY());
        controller.addShape(box);
        controller.setFlag("");
        repaint();
    }
    public void drawHelloworld(MouseEvent e)
    {
        Helloworld helloworld = new Helloworld(e.getX(), e.getY());
        controller.addShape(helloworld);
        controller.setFlag("");
        repaint();
    }
    public void drawUndo()
    {
        controller.removeShape();
        repaint();
    }
    public void drawRedo()
    {
        controller.addShapeRedo();
        repaint();
    }
}
