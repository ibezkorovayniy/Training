import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by i.bezkorovayniy on 25.07.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Model model = new Model();
        View view = new View();
        Controller control = new Controller(model, view);
        control.numberGame();


    }
}
