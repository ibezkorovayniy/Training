/**
 * Created by i.bezkorovayniy on 25.07.2017.
 */
public class Model {

    private int minBorder;
    private int maxBorder;
    private int secretNumber;
    private int userNumber;
    View view;

    //set

    public void setMinBorder(int minBorder)
    {
        this.minBorder = minBorder;
    }

    public void setMaxBorder(int maxBorder) {
        this.maxBorder = maxBorder;
    }

    public void setUserNumber(int userNumber) {

        this.userNumber = userNumber;

    }

    //get

    public int getMinBorder() {
        return minBorder;
    }

    public int getMaxBorder() {
        return maxBorder;
    }

    public int getSecretNumber() {
        return secretNumber;
    }

    public int getUserNumber() {
        return userNumber;
    }


    //random number

    public void setSecretNumber(int minBorder, int maxBorder)
    {
        maxBorder -= minBorder;
        this.secretNumber = (int) (Math.random() * ++maxBorder) + minBorder;
    }
}
