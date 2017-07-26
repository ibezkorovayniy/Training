import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by i.bezkorovayniy on 25.07.2017.
 */
public class Controller {

    private Model model;
    private View view;
     int intValue = 0;
   


    public Controller(Model model, View view)
    {
        this.model = model;
        this.view = view;
    }


    public void numberGame() throws IOException {
        model.setMinBorder(1);
        model.setMaxBorder(99);
        model.setSecretNumber(model.getMinBorder(), model.getMaxBorder());
        view.printMessage(view.MORE_OR_LESS_GAME);
        view.printMessage(view.PICK_A_NUMBER);
        setUserNumber();
    }

    public void setUserNumber() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        inputNumber(reader);
    }

    void inputNumber(BufferedReader reader) throws IOException {
        while (model.getSecretNumber() != intValue) {
            try {
                intValue = Integer.parseInt(reader.readLine());

                if (intValue > model.getMaxBorder() || intValue < model.getMinBorder()) {
                    view.printMessage(view.WRONG_RANGE);
                    view.addStat(intValue);
                } else {
                    view.addStat(intValue);
                    compare(intValue);
                }
            } catch (NumberFormatException e) {
                view.printMessage(view.WRONG_INPUT);
            }
        }
        view.printMessage(view.WINNER);
        view.printStat();
    }

    public void compare(int userNumber) throws IOException {
        if(userNumber >model.getSecretNumber())
        {
            view.printMessage(view.NUMBER_IS_BIGGER);
            model.setMaxBorder(intValue);
            view.changeRange((model.getMinBorder()), model.getMaxBorder());
        }
        else
        {
            view.printMessage(view.NUMBER_IS_LOWER);
            model.setMinBorder(intValue);
            view.changeRange(model.getMinBorder(), (model.getMaxBorder()));

        }
    }
}





