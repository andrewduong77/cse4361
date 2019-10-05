package hw1;

import java.util.ArrayList;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Color;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel; 

interface shape
{
    public void Draw(Graphics2D graphics);
}
class Circle implements shape
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
class Box implements shape
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
class JPanelDraw extends JPanel
{
//    private ArrayList<shape> points = new ArrayList<shape>();
//    public String figure = "";
    @Override
    public void paintComponent(Graphics g)
    {
//        super.paintComponent(g);
//        Graphics2D g2 = (Graphics2D) g;
//        for(shape point : points)
//        {
//            point.Draw(g2);
//        }
    }
    public JPanelDraw()
    {
        addMouseListener(new MouseAdapter()
        {
//            public void mousePressed(MouseEvent e)
//            {
//                if(figure.equals("circle"))
//                {
//                    Circle c = new Circle(e.getX(), e.getY());
//                    System.out.println("Circle");
//                }
//                if(figure.equals("box"))
//                {
//                    Box s =new Box(e.getX(), e.getY());
//                    System.out.println("Box");
//                }
//                repaint();
//            }
        });
    }
}
class Model
{
    private ArrayList<Point> points;
    private ArrayList<Point> points2;
    public static String flag = "";
    
    public Model()
    {
        points = new ArrayList<Point>();
        points2 = new ArrayList<Point>();
    }
    public void addPoint(String s)
    {
        if(s == "circle")
        {
            points.add(new Point());
        }
        if(s == "box")
        {
            points.add(new Point());
        }
    }
    public void getPoint(int i)
    {
        points.get(i);
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

        // create a new buttons
        // JButton buttonCircle, buttonBox;
        JButton buttonCircle = new JButton("Circle");
        JButton buttonBox = new JButton("Box");

        // create a panel to add buttons 
        JPanel panelLeft = new JPanel(); 
        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
        panelLeft.setBackground(Color.DARK_GRAY);

        JPanel panelRight = new JPanel();
        panelRight.setBackground(Color.white); 

        // add buttons and textfield to panel 
        panelLeft.add(buttonCircle,BorderLayout.WEST); 
        panelLeft.add(buttonBox,BorderLayout.WEST);

        // add panel to frame 
        frame.add(panelLeft,BorderLayout.WEST);
        frame.add(panelRight);

        // set the size of frame 
        frame.setSize(600, 400); 
        frame.setVisible(true);

        buttonCircle.addActionListener(controller.actionListenerCircle);
        buttonBox.addActionListener(controller.actionListenerBox);
    }
}
class Controller extends JPanel
{
    private Model model = new Model();
    public Controller(Model model)
    {
        this.model = model;
        addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                if(model.flag.equals("circle"))
                {
                    Circle c = new Circle(e.getX(), e.getY());
                    System.out.println("Drawing Circle");
                }
                if(model.flag.equals("box"))
                {
                    Box s = new Box(e.getX(), e.getY());
                    System.out.println("Drawing Box");
                }
                repaint();
            }
        });
    }
    public static ActionListener actionListenerCircle = new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            Model.flag = "circle";
            System.out.println("flag set to circle");
        }
    };
    public static ActionListener actionListenerBox = new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            Model.flag = "box";
            System.out.println("flag set to box");
        }
    };
//    public static MouseAdapter mouseAdapterDraw = new MouseAdapter()
//    {
//        public void mousePressed(MouseEvent e)
//        {
//
//        }
//    };
}
class Hw1
{
//    private static final long serialVersionUID = 1L;
    public static void main(String[] args)
    {
        Model model = new Model();
        Controller controller = new Controller(model);
        View view = new View(model, controller);
    }
}
