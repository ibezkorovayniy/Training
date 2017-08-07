import sun.plugin.com.event.COMEventHandler;
import sun.security.provider.SHA;

import java.util.ArrayList;
import java.util.List;

public class CompositePattern {
    public static void main(String[] args) {
        Shape square1 = new Square();
        Shape square2 = new Square();
        Shape triangle1 = new Triangle();
        Shape square3 = new Square();
        Shape circle1 = new Circle();
        Shape circle2 = new Circle();
        Shape triangle2 = new Triangle();

        Composite composite = new Composite();
        Composite composite1 = new Composite();
        Composite composite2 = new Composite();

        composite1.addComponent(square1);
        composite1.addComponent(square2);
        composite1.addComponent(triangle1);
        composite2.addComponent(square3);
        composite2.addComponent(circle1);
        composite2.addComponent(circle2);
        composite2.addComponent(triangle2);

        composite.addComponent(composite1);
        composite.addComponent(composite2);
        composite.draw();
    }
}

interface Shape{
    void draw();
}

class Square implements Shape{
    public void draw() {
        System.out.println("Hi, I`m square");
    }
}
class Triangle implements Shape{
    public void draw() {
        System.out.println("Hi, I`m Triangle");
    }
}
class Circle implements Shape{
    public void draw() {
        System.out.println("Hi, I`m circle");
    }
}

class Composite implements Shape{
    private List<Shape> components = new ArrayList<>();
    public void addComponent(Shape component){
        components.add(component);
    }
    public void removeComponent(Shape component){
        components.remove(component);
    }
    public void draw() {
        for(Shape component: components){
            component.draw();
        }
    }
}