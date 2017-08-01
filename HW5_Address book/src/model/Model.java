package model;

import java.util.ArrayList;


public class Model {

    private ArrayList<User> userList = new ArrayList<>(10);
    private int id = 0;
     Validate valid;

    public void setId(){
        id+=1;
    }
    public int getId(){
        return id;
    }


    public void addUsers() {
        User user = new User();
        //user.validateExistingUsers();
        user.setUser();
        user.setContacts();
        user.setAddress();
        userList.add(user);
        setId();

    }

    public void printUserInfo(){
        userList.get(getId()-1).printSurnameAndName();
        userList.get(getId()-1).getContacts();
        userList.get(getId()-1).getAddress();
    }



}