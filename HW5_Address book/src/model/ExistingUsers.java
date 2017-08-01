package model;

public enum ExistingUsers {
    USER1("John Snow"),
    USER2("Alex White"),
    USER3("Bruce Willis"),
    USER4("Garry Cooper");
    private String value;

    ExistingUsers(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
