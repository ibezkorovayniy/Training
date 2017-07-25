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
     int tmp;


    public Controller(Model model, View view)
    {
        this.model = model;
        this.view = view;
    }

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void numberGame() throws IOException {
        model.setMinBorder(1);
        model.setMaxBorder(99);
        model.setSecretNumber(model.getMinBorder(), model.getMaxBorder());
        view.printMessage(view.MORE_OR_LESS_GAME);
        view.printMessage(view.PICK_A_NUMBER);
        setUserNumber();
        compare(model.getUserNumber(), model.getSecretNumber());
    }

    public void setUserNumber() throws IOException {
        checkRange();
        System.out.println(model.getUserNumber());
    }

    public boolean checkIntValue() throws IOException {
        try {
            intValue = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            view.printMessage(view.WRONG_INPUT);
            return false;
        }
        tmp = intValue;
        return true;
    }

    void checkRange() throws IOException {
        while(!checkIntValue()){
        }
        if(tmp < model.getMinBorder() || tmp > model.getMaxBorder())
        {
            view.printMessage(view.WRONG_RANGE);
            checkRange();
        }
        else
        {
            model.setUserNumber(tmp);
        }
    }

    public void compare(int secretNumber, int userNumber) throws IOException {
        while(secretNumber != userNumber)
        {
            if(userNumber > secretNumber)
            {
                view.printMessage(view.NUMBER_IS_BIGGER);
                model.setMaxBorder(model.getUserNumber());
                view.changeRange((model.getMinBorder()), model.getMaxBorder());

            }
            else
            {
                view.printMessage(view.NUMBER_IS_LOWER);
                model.setMinBorder(model.getUserNumber());
                view.changeRange(model.getMinBorder(), (model.getMaxBorder()));

            }
        }
            view.printMessage(view.WINNER);
        //view.printStat();
    }
}









