package hw4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Stack;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JFrame
{
//    private Controller controller = new Controller();
    private Stack<Shape> shapes;
    private JButton buttonCircle = new JButton();
    private JButton buttonBox = new JButton();
    private JPanelDraw panelRight = new JPanelDraw();
    public View()
    {
        // create a new frame to store text field and button 
        JFrame frame = new JFrame("HW1 GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create a new buttons
        buttonCircle = new JButton("Circle");
        buttonBox = new JButton("Box");

        // create a panel to add buttons 
        JPanel panelLeft = new JPanel(); 
        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
        panelLeft.setBackground(Color.LIGHT_GRAY);

        panelRight = new JPanelDraw();
        panelRight.setBackground(Color.white);
        panelRight.setShapes(shapes);

        // add buttons and textfield to panel 
        panelLeft.add(buttonCircle,BorderLayout.WEST); 
        panelLeft.add(buttonBox,BorderLayout.WEST);

        // add panel to frame 
        frame.add(panelLeft,BorderLayout.WEST);
        frame.add(panelRight);

        // set the size of frame 
        frame.setSize(600, 400); 
        frame.setVisible(true);

//        buttonCircle.addActionListener(new ActionListener()
//        {
//            public void actionPerformed(ActionEvent e)
//            {
//                CircleState circleState = new CircleState();
//                circleState.doAction(panelRight.getController().getContext());
//            }
//        });
//        buttonBox.addActionListener(new ActionListener()
//        {
//            public void actionPerformed(ActionEvent e)
//            {
//                BoxState boxState = new BoxState();
//                boxState.doAction(panelRight.getController().getContext());
//            }
//        });
//        panelRight.addMouseListener(new MouseAdapter()
//        {
//            public void mousePressed(MouseEvent e)
//            {
//                if(panelRight.getController().getContext().getState().toString().equals("Circle State"))
//                {
//                    panelRight.drawCircle(e);
//                    NoShapeState noShapeState = new NoShapeState();
//                    noShapeState.doAction(panelRight.getController().getContext());
//                }
//                if(panelRight.getController().getContext().getState().toString().equals("Box State"))
//                {
//                    panelRight.drawBox(e);
//                    NoShapeState noShapeState = new NoShapeState();
//                    noShapeState.doAction(panelRight.getController().getContext());
//                }
//                repaint();
//            }
//        });
    }
    public JButton getButtonCircle()
    {
        return buttonCircle;
    }
    public JButton getButtonBox()
    {
        return buttonBox;
    }
    public JPanelDraw getPanelRight()
    {
        return panelRight;
    }
    public void setShapes(Stack<Shape> shapes)
    {
        this.shapes = shapes;
    }
}
