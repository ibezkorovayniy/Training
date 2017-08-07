import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class ObserverPattern {
    public static void main(String[] args) {
        MeteoStation station = new MeteoStation();
        station.addObserver(new ConsoleObserver());
        station.setMeasurements(25, 760);
        station.setMeasurements(-5, 745);

    }
}

interface Observed{
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

interface Observer{
    void handleEvent(int tmp, int pressure);
}

class MeteoStation implements Observed{
    int temperature;
    int pressure;
    List<Observer> observers = new ArrayList<>();
    public void setMeasurements(int tmp, int pres){
        temperature = tmp;
        pressure = pres;
        notifyObservers();
    }
    public void addObserver(Observer o) {
        observers.add(o);
    }
    public void removeObserver(Observer o) {
        observers.remove(o);
    }
    public void notifyObservers() {
        for(Observer o: observers ){
            o.handleEvent(temperature, pressure);
        }

    }
}
class ConsoleObserver implements Observer{
    public void handleEvent(int tmp, int pressure) {
        System.out.println("The weather has been changed. Temperature is now " + tmp + ", pressure is now " + pressure);
    }
}

class FileObserver implements Observer{
    @Override
    public void handleEvent(int tmp, int pressure) {
        File f;
        try{
            f = File.createTempFile("TempPressure", "_txt");
            PrintWriter pw = new PrintWriter(f);
            pw.print("\"The weather has been changed. Temperature is now \" + tmp + \", pressure is now \" + pressure");
            pw.println();
            pw.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}