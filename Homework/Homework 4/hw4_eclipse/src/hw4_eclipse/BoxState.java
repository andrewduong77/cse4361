package hw4_eclipse;

public class BoxState implements State
{
    public void doAction(Context context)
    {
        context.setState(this);
    }
    public String toString()
    {
        return "Box State";
    }
}
