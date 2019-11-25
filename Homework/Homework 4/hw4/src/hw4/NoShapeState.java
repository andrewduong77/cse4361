package hw4;

public class NoShapeState implements State
{
    public NoShapeState()
    {
        
    }
    public void doAction(Context context)
    {
        System.out.println("Controller is in No Shape State.");
        context.setState(this);
    }
    public String toString()
    {
        return "No Shape State";
    }
}
