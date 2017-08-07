import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;
import sun.security.provider.SHA;

public class StatePattern {
    public static void main(String[] args) {
//        Station kissfm = new KissFM();
//        Radio radio = new Radio();
//        radio.setStation(kissfm);
//        for(int i = 0; i < 10; i++){
//            radio.play();
//            radio.nextStation();
//        }
        Human1 human = new Human1();
        human.setState(new Work());
        for(int i = 0; i < 10; i++){
            human.doSomething();
        }
    }
}
class Human1{
    private Activity state;
    public void setState(Activity s){
        this.state = s;
    }
    public void doSomething(){
        state.doSomething(this);
    };
}

interface Activity{
    void doSomething(Human1 context);
}

class Work implements Activity{
    public void doSomething(Human1 context) {
        System.out.println("Working hard");
        context.setState(new Weekend());
    }
}
class Weekend implements Activity{
    private int count = 0;
    public void doSomething(Human1 context) {
        if(count < 3){
            System.out.println("I have a rest, sorry guys");
            count ++;
        } else{
            context.setState(new Work());
        }

    }
}




interface Station{
    void play();
}
class Radio7 implements Station{
    public void play(){
        System.out.println("Radio7...");
    }
}
class KissFM implements Station{
    public void play(){
        System.out.println("KissFM...");
    }
}
class Shansone implements Station{
    public void play(){
        System.out.println("Shanson...");
    }
}

class Radio{
    Station station;
    void setStation(Station st){
        station = st;
    }
    void nextStation(){
        if(station instanceof Radio7){
            setStation(new KissFM());
        } else if(station instanceof KissFM){
            setStation(new Shansone());
        } else if(station instanceof Shansone){
            setStation(new Radio7());
        }
    }
    void play(){
        station.play();
    }
}