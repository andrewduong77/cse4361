package hw4;

public class Context
{
    private State currentState;
    public Context()
    {
        currentState = new NoShapeState();
    }
    public void setState(State state)
    {
        currentState = state;
    }
    public State getState()
    {
        return currentState;
    }
}
