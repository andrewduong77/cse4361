package hw2;

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
    private ArrayList<Shape> points;
    public static String flag = "";
    
    public Model()
    {
        points = new ArrayList<Shape>();
    }
    public void addPoint(Shape shape)
    {
        points.add(shape);
    }
    public void removePoint(int i)
    {
        points.remove(points.size() - 1);
    }
    public void getPoint(int i)
    {
        points.get(i);
    }
    public ArrayList<Shape> getPoints()
    {
         return points;
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

        buttonCircle.addActionListener(controller.actionListenerCircle);
        buttonBox.addActionListener(controller.actionListenerBox);
        buttonUndo.addActionListener(controller.actionListenerUndo);
        buttonRedo.addActionListener(controller.actionListenerRedo);
    }
}
class Controller implements MouseListener
{
    private Model model = new Model();
    public Controller(Model model)
    {
        this.model = model;

    }
    public static ActionListener actionListenerCircle = new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            Model.flag = "circle";
        }
    };
    public static ActionListener actionListenerBox = new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            Model.flag = "box";
        }
    };
    public static ActionListener actionListenerUndo = new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
//            model.removePoint();
        }
    };
    public static ActionListener actionListenerRedo = new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            
        }
    };

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
class JPanelDraw extends JPanel
{
    private Model model = new Model();
    private Controller controller = new Controller(model);
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for(Shape point : model.getPoints())
            point.Draw(g2);
    }
    public JPanelDraw()
    {
        addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                if(model.flag.equals("circle"))
                {
                    Circle circle = new Circle(e.getX(), e.getY());
                    model.addPoint(circle);
                }
                if(model.flag.equals("box"))
                {
                    Box box = new Box(e.getX(), e.getY());
                    model.addPoint(box);
                }
                repaint();
            }
        });
    }
}
class Hw2
{
    public static void main(String[] args)
    {
        Model model = new Model();
        Controller controller = new Controller(model);
        View view = new View(model, controller);
    }
}
