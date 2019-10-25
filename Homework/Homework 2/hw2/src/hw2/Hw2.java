package hw2;

import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

interface Shape
{
    public void Draw(Graphics2D graphics);
}
class Circle implements Shape
{
    private int x, y;
    public Circle(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public void Draw(Graphics2D g)
    {
        g.drawOval(x, y, 75, 75);
    }
}
class Box implements Shape
{
    private int x, y;
    public Box(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public void Draw(Graphics2D g)
    {
        g.drawRect(x, y, 75, 75);
    }
}
class Model
{
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
class View extends JFrame
{
    private Model model = new Model();
    private Controller controller = new Controller(model);
    public View(Model model, Controller controller)
    {
        // create a new frame to store text field and button 
        JFrame frame = new JFrame("HW1 GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create a new buttons
        JButton buttonCircle = new JButton("Circle");
        JButton buttonBox = new JButton("Box");
        JButton buttonUndo = new JButton("Undo");
        JButton buttonRedo = new JButton("Redo");

        // create a panel to add buttons 
        JPanel panelLeft = new JPanel(); 
        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
        panelLeft.setBackground(Color.LIGHT_GRAY);

        JPanelDraw panelRight = new JPanelDraw();
        panelRight.setBackground(Color.white); 

        // add buttons and textfield to panel 
        panelLeft.add(buttonCircle,BorderLayout.WEST); 
        panelLeft.add(buttonBox,BorderLayout.WEST);
        panelLeft.add(buttonUndo,BorderLayout.WEST);
        panelLeft.add(buttonRedo,BorderLayout.WEST);

        // add panel to frame 
        frame.add(panelLeft,BorderLayout.WEST);
        frame.add(panelRight);

        // set the size of frame 
        frame.setSize(600, 400); 
        frame.setVisible(true);

        buttonCircle.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                model.setFlag("circle");
            }
        });
        buttonBox.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                model.setFlag("box");
            }
        });
        buttonUndo.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                model.removePoint();
                repaint();
            }
        });
        buttonRedo.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                
            }
        });
        panelRight.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                if(model.getFlag().equals("circle"))
                {
                    panelRight.drawCircle(e);
                }
                if(model.getFlag().equals("box"))
                {
                    panelRight.drawBox(e);
                }
                repaint();
            }
        });
    }
}
class Controller
{
    private Model model = new Model();
    public Controller(Model model)
    {
        this.model = model;
    }
}
class JPanelDraw extends JPanel
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
public class Hw2
{
    public static void main(String[] args)
    {
        Model model = new Model();
        Controller controller = new Controller(model);
        View view = new View(model, controller);
    }
}
