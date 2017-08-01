package view;

public class View {

     public static String ENTER_NAME = "Enter your name: ";
     public static String ENTER_SURNAME = "Enter your surname: ";
     public static String ENTER_LASTNAME = "Enter your lastname: ";
     public static String ENTER_NICKNAME = "Enter your nickname: ";

     public static String ENTER_COMMENT = "Enter comment (If needed): ";

     public static String ENTER_HOMEPHONE = "Enter your Home phone number(type skip if you want ro skip): ";
     public static String ENTER_MOBPHONE = "Enter your mobile phone number in format:(0XX-XXX-XX-XX): ";
     public static String ENTER_MOBPHONE2 = "Enter your second mobile phone number(type skip if you want ro skip): ";
     public static String ENTER_MAIL = "Enter your e-mail: ";
     public static String ENTER_SKYPE = "Enter Skype: ";

     public static String ENTER_INDEX = "Enter your postal code: ";
     public static String ENTER_CITY = "Enter your City: ";
     public static String ENTER_STREET = "Enter street: ";
     public static String ENTER_BUILDING = "Enter building number: ";
     public static String ENTER_FLAT = "Enter your flat number: ";

     public static String USER_CREATED = "User has been created: ";
     public static String SHOW_CONTACTS = "User contacts: ";
     public static String SHOW_ADDRESS = "User address: ";


     public void printMessage(String message){
         System.out.println(message);
     }


}
