package controller;

import model.Model;
import model.User;
import model.Validate;
import view.View;
import java.util.Scanner;

public class Controller {

    private Model model;
    private View view;
    private User user;

    public Controller(Model model, View view, User user, Validate validate){
        this.model = model;
        this.view = view;
        this.user = user;
    }

    public void createNewUser() {
        model.addUsers();
        view.printMessage(view.USER_CREATED);
        model.printUserInfo();
    }

}
