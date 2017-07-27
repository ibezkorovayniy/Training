package Plants;

/**
 * Created by i.bezkorovayniy on 27.07.2017.
 */
public class NotFlower extends Plant{

    private String name;

    public NotFlower(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
