package hw4_eclipse;

public class CircleState implements State
{
    public void doAction(Context context)
    {
        context.setState(this);
    }
    public String toString()
    {
        return "Circle State";
    }
}
