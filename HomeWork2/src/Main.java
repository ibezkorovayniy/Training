/**
 * Created by Illia on 23.07.2017.
 */
public class Main
{
    public static void main (String[] args)
    {
        Model model = new Model();
        View view = new View();
        Controller control = new Controller(model, view );
        control.numberGame();
    }


}
