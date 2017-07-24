import java.util.Scanner;

/**
 * Created by Illia on 23.07.2017.
 */
public class Controller
{
    private Model model;
    private View view;

    public Controller(Model model, View view)
    {
        this.model = model;
        this.view = view;
    }

    Scanner sc = new Scanner(System.in);

    public void numberGame()
    {
        model.setMinBorder(1);
        model.setMaxBorder(99);
        model.setSecretNumber(model.getMinBorder(), model.getMaxBorder());
        
        view.printMessage(view.MORE_OR_LESS_GAME);
        view.printMessage(view.PICK_A_NUMBER);
        model.setUserNumber(checkValue(checkInt(sc)));
        compare(model.getSecretNumber(), model.getUserNumber());
    }

 public int checkInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            view.printMessage(view.WRONG_INPUT);
            sc.next();
        }
        return sc.nextInt();
    }
    public int checkValue(int value) {
        while (value > model.getMaxBorder() || value < model.getMinBorder()) {
            view.printMessage(view.WRONG_RANGE);
            value = checkInt(sc);
        }

        return value;
    }

    public void compare(int secretNumber, int userNumber)
    {

        if(secretNumber != userNumber)
        {
            if(userNumber > secretNumber)
            {
                view.printMessage(view.NUMBER_IS_BIGGER);
                model.setMaxBorder(model.getUserNumber());

                view.changeRange((model.getMinBorder()), model.getMaxBorder());
                model.setUserNumber(checkValue(checkInt(sc)));
                compare(model.getSecretNumber(), model.getUserNumber());
            }
            else
            {
                view.printMessage(view.NUMBER_IS_LOWER);
                model.setMinBorder(model.getUserNumber());

                view.changeRange(model.getMinBorder(), (model.getMaxBorder()));
                model.setUserNumber(checkValue(checkInt(sc)));
                compare(model.getSecretNumber(), model.getUserNumber());
            }
        } else

            view.printMessage(view.WINNER);
            view.printStat();
    }
}
