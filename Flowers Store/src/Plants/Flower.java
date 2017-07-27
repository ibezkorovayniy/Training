package Plants;

/**
 * Created by i.bezkorovayniy on 27.07.2017.
 */
public class Flower extends Plant {
    private String name;

    public Flower(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    enum Feeding {
        NEED, NOT_NEED
    }
}
