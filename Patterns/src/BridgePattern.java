public class BridgePattern {
    public static void main(String[] args) {
        Carr c = new Sedan(new Kia());
        c.showDetails();

    }
}

abstract class Carr{
    Make make;
    public Carr(Make m){
        make = m;
    }
    abstract void showType();
    void showDetails(){
        showType();
        make.setMake();
    }

}
class Sedan extends Carr{
public Sedan(Make m){
    super(m);
}
    void showType() {
        System.out.println("Sedan");
    }
}

class HatchBack extends Carr{
    public HatchBack(Make m){
        super(m);
    }
    void showType() {
        System.out.println("HatchBack");
    }
}

interface Make{
    void setMake();
}
class Kia implements Make{
    public void setMake() {
        System.out.println("KIA");
    }
}

class Skoda implements Make{
    public void setMake() {
        System.out.println("Skoda");
    }
}