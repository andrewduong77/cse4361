package hw2;

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
