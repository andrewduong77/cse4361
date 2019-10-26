package sample;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JFrame
{
    private Controller controller = new Controller();
    public View(Controller controller)
    {
        // create a new frame to store text field and button
        JFrame frame = new JFrame("HW1 GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create a new buttons
        JButton buttonCircle = new JButton("Circle");
        JButton buttonBox = new JButton("Box");
        JButton buttonHelloworld = new JButton("Helloworld");
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
        panelLeft.add(buttonHelloworld,BorderLayout.WEST);
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
                controller.setFlag("circle");
            }
        });
        buttonBox.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                controller.setFlag("box");
            }
        });
        buttonHelloworld.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                controller.setFlag("helloworld");
            }
        });
        buttonUndo.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                panelRight.drawUndo();
            }
        });
        buttonRedo.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                panelRight.drawRedo();
            }
        });
        panelRight.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                if(controller.getFlag().equals("circle"))
                {
                    panelRight.drawCircle(e);
                }
                if(controller.getFlag().equals("box"))
                {
                    panelRight.drawBox(e);
                }
                if(controller.getFlag().equals("helloworld"))
                {
                    panelRight.drawHelloworld(e);
                }
                repaint();
            }
        });
    }
}
