package hw4;

public class CircleState implements State
{
    public CircleState()
    {
        
    }
    public void doAction(Context context)
    {
        System.out.println("Controller is in Circle State.");
        context.setState(this);
    }public String toString()
    {
        return "Circle State";
    }
}
