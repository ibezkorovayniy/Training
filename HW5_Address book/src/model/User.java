package model;

import view.View;

import java.util.Scanner;

public class User {

    private String name, surname, lastname, nickname;
    private String comment;
    private String homePhone, mobPhone, mobPhone2;
    private String mail, skype;
    private String index, city, street, building, flat;

    private View view = new View();
    private Validate validate = new Validate();
    Scanner sc = new Scanner(System.in);

    // Setters
    public void setName(String name) {

        this.name = name;
    }

    public void setSurname(String surname) {

        this.surname = surname;
    }

    public void setLastname(String lastname) {

        this.lastname = lastname;
    }

    public void setNickname(String nickname) {

        this.nickname = nickname;
    }

    public void setComment(String comment) {

        this.comment = comment;
    }

    public void setHomePhone(String homePhone) {

        this.homePhone = homePhone;
    }

    public void setMobPhone(String mobPhone) {

        this.mobPhone = mobPhone;
    }

    public void setMobPhone2(String mobPhone2) {

        this.mobPhone2 = mobPhone2;
    }

    public void setMail(String mail) {

        this.mail = mail;
    }

    public void setSkype(String skype) {

        this.skype = skype;
    }

    public void setIndex(String index) {

        this.index = index;
    }

    public void setCity(String city) {

        this.city = city;
    }

    public void setStreet(String street) {

        this.street = street;
    }

    public void setBuilding(String building) {

        this.building = building;
    }

    public void setFlat(String flat) {

        this.flat = flat;
    }

    //set user name, surname, last name and nick name
    public void setUser() {
        validateExistingUsers();
        view.printMessage(view.ENTER_LASTNAME);
        setLastname(sc.next());
        view.printMessage(view.ENTER_NICKNAME);
        setNickname(sc.next());
        view.printMessage(view.ENTER_COMMENT);
        setComment(sc.next());
    }

    //set user contacts
    public void setContacts() {
        setHomePhone(validate.validateHomePhone(view.ENTER_HOMEPHONE));
        setMobPhone(validate.validateMobPhone(view.ENTER_MOBPHONE));
        setMobPhone2(validate.validateMobPhone2(view.ENTER_MOBPHONE2));
        setMail(validate.validateEmail(view.ENTER_MAIL));
        view.printMessage(view.ENTER_SKYPE);
        setSkype(sc.next());
    }

    //set user address
    public void setAddress() {
        view.printMessage(view.ENTER_INDEX);
        setIndex(sc.next());
        view.printMessage(view.ENTER_CITY);
        setCity(sc.next());
        view.printMessage(view.ENTER_STREET);
        setStreet(sc.next());
        view.printMessage(view.ENTER_BUILDING);
        setBuilding(sc.next());
        view.printMessage(view.ENTER_FLAT);
        setFlat(sc.next());
    }


    //Getters

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getComment() {
        return comment;
    }

    //Contacts
    public String getHomePhone() {
        return homePhone;
    }

    public String getMobPhone() {
        return mobPhone;
    }

    public String getMobPhone2() {
        return mobPhone2;
    }

    public String getMail() {
        return mail;
    }

    public String getSkype() {
        return skype;
    }

    //Address
    public String getIndex() {
        return index;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getBuilding() {
        return building;
    }

    public String getFlat() {
        return flat;
    }

    //Get contacts
    public void getContacts() {
        view.printMessage(view.SHOW_CONTACTS);
        System.out.println(getHomePhone());
        System.out.println(getMobPhone());
        System.out.println(getMobPhone2());
        System.out.println(getMail());
        System.out.println(getSkype());
    }

    //Get Address
    public void getAddress() {
        view.printMessage(view.SHOW_ADDRESS);
        System.out.println(getIndex() + ", " + getCity() + ", " + getStreet() + ", " + getBuilding() + ", " + getFlat());
    }

    //get user
    public void printSurnameAndName() {
        System.out.println(surname + " " + name.substring(0, 1) + ".");
    }

    public String getNameSurnameForCheck() {
        view.printMessage(view.ENTER_NAME);
        setName(sc.next());
        view.printMessage(view.ENTER_SURNAME);
        setSurname(sc.next());
        return getName() + " " + getSurname();
    }


    public void validateExistingUsers() {
        String tmp = getNameSurnameForCheck();
        for (ExistingUsers existingUsers : ExistingUsers.values()) {
            String checkUser = existingUsers.getValue();
            while(checkUser.equalsIgnoreCase(tmp)) {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    System.out.println("Such user is already exist, try again with different name and surname: ");
                }
                tmp = getNameSurnameForCheck();
            }
        }
        System.out.println("User is valid.");
        }
    }

