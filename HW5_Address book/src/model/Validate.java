package model;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {

    Scanner input = new Scanner(System.in);


    public String validateEmail(String message) {
        String expression = "\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}\\b";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        String strOut = "";
        boolean valid = true;
        System.out.println(message);
        while (valid) {
            try {
                strOut = input.next();
                CharSequence emailChk = strOut;
                Matcher matcher = pattern.matcher(emailChk);
                if (!matcher.matches()) {
                    throw new Exception();
                }
                valid = false;
            } catch (Exception e) {
                System.out.println("Please, enter a valid e-mail");
            }
        }
        return strOut;
    }

    public String validateHomePhone(String message) {
        String expression = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";
        Pattern pattern = Pattern.compile(expression);
        String strOut = "";
        boolean valid = true;
        System.out.println(message);
        while (valid) {
            try {
                strOut = input.next();
                if (! strOut.equalsIgnoreCase("skip")){
                    CharSequence homePhoneChk = strOut;
                    Matcher matcher = pattern.matcher(homePhoneChk);
                    if (!matcher.matches()) {
                        throw new Exception();
                    }
                    valid = false;
                } else {
                    strOut = "-";
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please, enter a valid home phone number");
            }
        }
        return strOut;
    }

    public String validateMobPhone(String message) {
        String expression = "((\\d{3})-(\\d{3}-\\d\\d-\\d\\d))";
        Pattern pattern = Pattern.compile(expression);
        String strOut = "";
        boolean valid = true;
        System.out.println(message);
        while (valid) {
            try {
                strOut = input.next();
                CharSequence mobPhoneChk = strOut;
                Matcher matcher = pattern.matcher(mobPhoneChk);
                if (!matcher.matches()) {
                    throw new Exception();
                }
                valid = false;
            } catch (Exception e) {
                System.out.println("Please, enter a valid mobile phone number");
            }
        }
        return strOut;
    }

    public String validateMobPhone2(String message) {
        String expression = "((\\d{3})-(\\d{3}-\\d\\d-\\d\\d))";
        Pattern pattern = Pattern.compile(expression);
        String strOut = "";
        boolean valid = true;
        System.out.println(message);
        while (valid) {
            try {
                strOut = input.next();
                if (! strOut.equalsIgnoreCase("skip")) {
                    CharSequence mobPhone2Chk = strOut;
                    Matcher matcher = pattern.matcher(mobPhone2Chk);
                    if (!matcher.matches()) {
                        throw new Exception();
                    }
                    valid = false;
                } else {
                    strOut = "";
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please, enter a valid second mobile phone number");
            }
        }
        return strOut;
    }

}
