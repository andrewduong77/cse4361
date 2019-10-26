package sample;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import javax.swing.JPanel;

public class JPanelDraw extends JPanel
{
    private Model model = new Model();
    private Controller controller = new Controller(model);
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Iterator<Shape> it = model.getShapes().iterator();
        while(it.hasNext())
            it.next().Draw(g2);
    }
    //    public JPanelDraw() {}
    public void drawCircle(MouseEvent e)
    {
        Circle circle = new Circle(e.getX(), e.getY());
        model.addShape(circle);
        model.setFlag("");
        repaint();
    }
    public void drawBox(MouseEvent e)
    {
        Box box = new Box(e.getX(), e.getY());
        model.addShape(box);
        model.setFlag("");
        repaint();
    }
    public void drawHelloworld(MouseEvent e)
    {
        Helloworld helloworld = new Helloworld(e.getX(), e.getY());
        model.addShape(helloworld);
        model.setFlag("");
        repaint();
    }
    public void drawUndo()
    {
        model.removeShape();
        repaint();
    }
    public void drawRedo()
    {
        model.addShapeRedo();
        repaint();
    }
}
