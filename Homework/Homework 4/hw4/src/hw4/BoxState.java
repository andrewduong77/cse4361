package hw4;

public class BoxState implements State
{
    public BoxState()
    {
        
    }
    public void doAction(Context context)
    {
        System.out.println("Controller is in Box State.");
        context.setState(this);
    }
    public String toString()
    {
        return "Box State";
    }
}
