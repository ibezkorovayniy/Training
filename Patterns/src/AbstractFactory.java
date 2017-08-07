/**
 * Created by i.bezkorovayniy on 03.08.2017.
 */
public class AbstractFactory {
    public static void main(String[] args) {

        DeviceFactory factory = getFactoryByCountryCode("Fr");
        Mouse m = factory.getMouse();
        Keyboard k = factory.getKeyboard();
        Touchpad t = factory.getTouchpad();

        m.click();
        k.print();
        k.println();
        t.track(10, 35);

    }
private static DeviceFactory getFactoryByCountryCode(String lang){
        switch (lang){
            case "Ua":
                return new UaDeviceFactory();
            case "En":
                return new EnDeviceFactory();
            default:
                throw new RuntimeException("Unsupported Country Code: " + lang);
        }
}


}

interface Mouse{
    void click();
    void dblclick();
    void scroll(int direction);
}

interface Keyboard{
    void print();
    void println();
}

interface Touchpad{
    void track(int deltaX, int deltaY);
}

interface DeviceFactory{
    Mouse getMouse();
    Keyboard getKeyboard();
    Touchpad getTouchpad();
}

class UaMouse implements Mouse{
    public void click(){
        System.out.println("Клацаєм мишою один раз");
    }

    public void dblclick() {
        System.out.println("Подвійне клацання мишою");
    }

    public void scroll(int direction) {
       if(direction > 0)
           System.out.println("Скрол вверх");
       else if(direction < 0)
           System.out.println("Скролимо вниз");
       else
           System.out.println("Не скролимо");
    }
}

class UaKeyboard implements Keyboard{

    public void print() {
        System.out.println("Друкуємо строку");
    }

    public void println() {
        System.out.println("Друкуємо з переводом строки");
    }
}

class UaTouchpad implements Touchpad{

    public void track(int deltaX, int deltaY) {
        int s = (int) Math.sqrt(Math.pow(deltaX,2) + Math.pow(deltaY, 2));
        System.out.println("Пересунулись на " + s + " пікселів");
    }
}


class EnMouse implements Mouse{
    public void click(){
        System.out.println("Mouse click");
    }

    public void dblclick() {
        System.out.println("Double click");
    }

    public void scroll(int direction) {
        if(direction > 0)
            System.out.println("Scroll up");
        else if(direction < 0)
            System.out.println("Scroll down");
        else
            System.out.println("No scroll");
    }
}

class EnKeyboard implements Keyboard{

    public void print() {
        System.out.println("Printing the string");
    }

    public void println() {
        System.out.println("Printing the string and go to nextline");
    }
}

class EnTouchpad implements Touchpad{

    public void track(int deltaX, int deltaY) {
        int s = (int) Math.sqrt(Math.pow(deltaX,2) + Math.pow(deltaY, 2));
        System.out.println("Moves on " + s + " pixels");
    }
}

class EnDeviceFactory implements DeviceFactory{

    public Mouse getMouse() {
        return new EnMouse();
    }

    public Keyboard getKeyboard() {
        return new EnKeyboard();
    }

    public Touchpad getTouchpad() {
        return new EnTouchpad();
    }
}
class UaDeviceFactory implements DeviceFactory{

    public Mouse getMouse() {
        return new UaMouse();
    }

    public Keyboard getKeyboard() {
        return new UaKeyboard();
    }

    public Touchpad getTouchpad() {
        return new UaTouchpad();
    }
}