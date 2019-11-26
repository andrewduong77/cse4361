package hw4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Stack;

public class Controller
{
//    private Stack<Shape> shapes = new Stack<Shape>();
    private Context context = new Context();
    private View view = new View();
    public Controller(View view)
    {
//        shapes = new Stack<Shape>();
        view.getButtonCircle().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("In " + context.getState().toString());
                CircleState circleState = new CircleState();
                circleState.doAction(context);
            }
        });
        view.getButtonBox().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("In " + context.getState().toString());
                BoxState boxState = new BoxState();
                boxState.doAction(context);
            }
        });
        view.getPanelRight().addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                if(context.getState().toString().equals("Circle State"))
                {
                    System.out.println("Drawing Circle");
                    drawCircle(e);
                    NoShapeState noShapeState = new NoShapeState();
                    noShapeState.doAction(context);
                }
                if(context.getState().toString().equals("Box State"))
                {
                    System.out.println("Drawing Box");
                    drawBox(e);
                    NoShapeState noShapeState = new NoShapeState();
                    noShapeState.doAction(context);
                }
                view.getPanelRight().repaint();
            }
        });
//        view.setShapes(shapes);
    }
    public void addShape(Shape shape)
    {
        view.getPanelRight().getShapes().push(shape);
    }
    public void getShape(int i)
    {
        view.getPanelRight().getShapes().get(i);
    }
    public Stack<Shape> getShapes()
    {
         return view.getPanelRight().getShapes();
    }
    public Context getContext()
    {
        return context;
    }
    public View getView()
    {
        return view;
    }
    public void drawCircle(MouseEvent e)
    {
        Circle circle = new Circle(e.getX(), e.getY());
        addShape(circle);
        view.getPanelRight().repaint();
    }
    public void drawBox(MouseEvent e)
    {
        Box box = new Box(e.getX(), e.getY());
        addShape(box);
        view.getPanelRight().repaint();
    }
}
