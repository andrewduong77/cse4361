package hw4;

public class Hw4
{
    public static void main(String[] args)
    {
//        Controller controller = new Controller();
//        View view = new View(controller);
        View view = new View();
        Controller controller = new Controller(view);
    }
}
