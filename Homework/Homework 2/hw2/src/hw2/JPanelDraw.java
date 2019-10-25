package hw2;

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
        Iterator it = model.getPoints().iterator();
        while(it.hasNext())
            ((Shape)it.next()).Draw(g2);
    }
//    public JPanelDraw() {}
    public void drawCircle(MouseEvent e)
    {
        Circle circle = new Circle(e.getX(), e.getY());
        model.addPoint(circle);
        model.setFlag("");
        repaint();
}
    public void drawBox(MouseEvent e)
    {
        Box box = new Box(e.getX(), e.getY());
        model.addPoint(box);
        model.setFlag("");
        repaint();
    }
}
