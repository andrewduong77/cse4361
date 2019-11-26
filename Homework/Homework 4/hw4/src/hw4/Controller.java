package hw4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Stack;

public class Controller
{
    private Stack<Shape> shapes;
    private Context context = new Context();
    private View view = new View();
    public Controller(View view)
    {
        shapes = new Stack<Shape>();
        view.getButtonCircle().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                CircleState circleState = new CircleState();
                circleState.doAction(context);
            }
        });
        view.getButtonBox().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
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
                    
                    drawCircle(e);
                    NoShapeState noShapeState = new NoShapeState();
                    noShapeState.doAction(context);
                }
                if(context.getState().toString().equals("Box State"))
                {
                    drawBox(e);
                    NoShapeState noShapeState = new NoShapeState();
                    noShapeState.doAction(context);
                }
                view.getPanelRight().repaint();
            }
        });
        view.setShapes(shapes);
    }
    public void addShape(Shape shape)
    {
        shapes.push(shape);
    }
    public void getShape(int i)
    {
        shapes.get(i);
    }
    public Stack<Shape> getShapes()
    {
         return shapes;
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
