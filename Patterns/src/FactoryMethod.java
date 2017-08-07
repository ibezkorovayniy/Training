import java.util.Date;

/**
 * Created by i.bezkorovayniy on 03.08.2017.
 */
public class FactoryMethod {

    public static void main(String[] args) {
        //Watch watch = new DigitalWatch();
        WatchMaker maker = new DigitalWatchMaker();
        Watch watch = maker.createWatch();
        watch.showTime();

    }

    public static WatchMaker getMakerByName(String maker){
        if(maker.equals("Digital"))
            return new DigitalWatchMaker();
         else if(maker.equals("Rome"))

            return new RomeWatchMaker();

            throw new RuntimeException("Such watch is not supported" + maker);
    }
}

interface Watch{
    void showTime();
}

class DigitalWatch implements Watch{
    public void showTime(){
        System.out.println(new Date());
    }
}

class RomeWatch implements Watch{
    public void showTime(){
        System.out.println("VII-XX");
    }
}

interface WatchMaker{
    Watch createWatch();
}

class DigitalWatchMaker implements WatchMaker{
    public Watch createWatch(){
        return new DigitalWatch();
    }
}

class RomeWatchMaker implements WatchMaker{
    public Watch createWatch(){
        return new RomeWatch();
    }
}