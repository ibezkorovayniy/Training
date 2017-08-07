
public class Builder {

    public static void main(String[] args) {
        Director director = new Director();
        director.setBuilder(new SubaruBuilder());
        Car car = director.BuildCar();
        System.out.println(car);

    }

}

abstract class CarBuilder{
    Car car;
    void createCar(){
        car = new Car();
    }
    Car getCar(){
        return car;
    }
    abstract void buildMake();
    abstract void buildTransmission();
    abstract void buildMaxSpeed();
}

class FordMondeoBuilder extends CarBuilder{

    void buildMake() {
        car.setMake("Ford Mondeo");
    }
    void buildTransmission() {
        car.setTransmission(Transmission.AUTO);
    }
    void buildMaxSpeed() {
        car.setMaxSpeed(260);
    }
}
class SubaruBuilder extends CarBuilder{
    void buildMake() {
        car.setMake("Subaru");
    }
    void buildTransmission() {
        car.setTransmission(Transmission.MANUAL);
    }
    void buildMaxSpeed() {
        car.setMaxSpeed(320);
    }
}
class Director{
    CarBuilder builder;
    void setBuilder(CarBuilder b)
    {
        builder = b;
    }
    Car BuildCar(){
        builder.createCar();
        builder.buildMake();
        builder.buildTransmission();
        builder.buildMaxSpeed();
        Car car = builder.getCar();
        return car;
    }

}



enum Transmission{
    MANUAL, AUTO
}


class Car {
    String make;
    Transmission transmission;
    int maxSpeed;
    public void setMake(String make) {
        this.make = make;
    }
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
    public String toString() {
        return "Car" + " make " + make + " transmission " + transmission + " Maxspeed " + maxSpeed;
    }
}

