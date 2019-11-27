package hw4_eclipse;

public class NoShapeState implements State
{
    public void doAction(Context context)
    {
        context.setState(this);
    }
    public String toString()
    {
        return "No Shape State";
    }
}
