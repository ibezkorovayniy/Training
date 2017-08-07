/**
 * Created by i.bezkorovayniy on 02.08.2017.
 */
public class Facade {

    public static void main(String[] args) {

//        Power power = new Power();
//        power.on();
//        DVDRom dvdRom = new DVDRom();
//        dvdRom.load();
//        HDD hdd = new HDD();
//        hdd.copyFromDVD(dvdRom);

        Computer computer = new Computer();
        computer.copy();

    }

}

class Computer{
    Power power = new Power();
    DVDRom dvdRom = new DVDRom();
    HDD hdd = new HDD();
    void copy(){
        power.on();
        dvdRom.load();
        hdd.copyFromDVD(dvdRom);
        power.off();
    }
}

class Power{
    void on(){
        System.out.println("Power On");
    }
    void off(){
        System.out.println("Power Off");
    }
}

class DVDRom {
    private boolean data = false;
    public boolean hasData(){
        return data;
    }
    void load(){
        data = true;
    }
    void unload(){
        data = false;
    }
}

class HDD {
    void copyFromDVD(DVDRom dvd){
        if(dvd.hasData()){
            System.out.println("Copying from dvd-disk");
        } else {
            System.out.println("Put dvd-disk with data");
        }
    }
}