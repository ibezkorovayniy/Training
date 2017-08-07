import java.util.ArrayList;
import java.util.List;

public class MediatorPattern {
    public static void main(String[] args) {
        TextChat chat = new TextChat();
        User1 admin = new Admin(chat);
        User1 u1 = new SimpleUser(chat );
        User1 u2 = new SimpleUser(chat);

        chat.setAdmin(admin);
        chat.addUser(u1);
        chat.addUser(u2);
        u1.sendMessage("Hi, i`m a stupid user");
        admin.sendMessage("Watch out! Admin is here!");

    }
}

interface User1{
    abstract void sendMessage(String message);
    abstract void getMessage(String message);
}

interface Chat{
    void sendMessage(String message, User1 user);
}

class Admin implements User1{
    Chat chat;
    public Admin(Chat chat){
        this.chat = chat;
    }
    public void sendMessage(String message){
        chat.sendMessage(message, this);
    }
    public void getMessage(String message){
        System.out.println("Admin receive a message: " + message + "'");
    }
}
class SimpleUser implements User1{
    Chat chat;
    public SimpleUser(Chat chat){
        this.chat = chat;
    }
    public void sendMessage(String message){
        chat.sendMessage(message, this);
    }
    public void getMessage(String message){
        System.out.println("User receive a message: " + message + "'");
    }
}

class TextChat implements Chat{
    User1 admin;
    List<User1> users = new ArrayList<>();
    public void setAdmin(User1 admin) {
        this.admin = admin;
    }
    public void addUser(User1 user){
        users.add(user);
    }
    public void sendMessage(String message, User1 user) {
        for(User1 u : users ){
            u.getMessage(message);
        }
        admin.getMessage(message);
    }
}