package hw4_eclipse;

public class Context
{
    private State currentState;
    public Context()
    {
        currentState = null;
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
