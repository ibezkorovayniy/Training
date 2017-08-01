import com.sun.org.apache.xpath.internal.operations.Mod;
import controller.Controller;
import model.ExistingUsers;
import model.Model;
import model.User;
import model.Validate;
import view.View;


public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        User user = new User();
        Validate validate = new Validate();
        Controller controller = new Controller(model, view, user, validate);
        controller.createNewUser();

    }




}
