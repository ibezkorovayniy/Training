/**
 * Created by i.bezkorovayniy on 25.07.2017.
 */
public class View {

    static String MORE_OR_LESS_GAME = "This is more or less game";
    static String PICK_A_NUMBER = "Pick a number between 0 and 100(except 0 and 100)";
    static String NUMBER_IS_BIGGER = "Your number is too big";
    static String NUMBER_IS_LOWER = "Your number is too low";
    static String WRONG_RANGE = "Your number is out of the range";
    static String WRONG_INPUT = "You must enter an integer number";
    static String WINNER = "You win!";




    void printMessage(String message)
    {
        System.out.println(message);
    }

    void changeRange(int minBorder, int maxBorder)
    {
        System.out.println("Now try again between " + minBorder + " and " + maxBorder);
    }


/*
    public void printStat()
    {
        for(int stat : list)
        {
            System.out.println(stat);
        }
    }
    */
}
