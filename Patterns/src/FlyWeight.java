import sun.security.provider.SHA;

import java.util.*;

public class FlyWeight {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        List<Shape1> shapes = new ArrayList<>();
        shapes.add(shapeFactory.getShape("square"));
        shapes.add(shapeFactory.getShape("point"));
        shapes.add(shapeFactory.getShape("circle"));
        shapes.add(shapeFactory.getShape("square"));
        shapes.add(shapeFactory.getShape("circle"));

        Random rand = new Random();
        for(Shape1 shape:shapes){
            int x  = rand.nextInt(100);
            int y = rand.nextInt(100);
            shape.draw(x,y);
        }

    }
}
interface Shape1 {
    void draw(int x, int y);
}
class Point1 implements Shape1{
    public void draw(int x, int y) {
        System.out.println("("+x+","+y+"): drawing a line ");
    }
}
class Circle1 implements Shape1{
    int r = 5;
    public void draw(int x, int y) {
        System.out.println("("+x+","+y+"): drawing a circle " + r);
    }
}
class Square1 implements Shape1{
    int a = 10;
    public void draw(int x, int y) {
        System.out.println("("+x+","+y+"): drawing a square " + a);
    }
}
class ShapeFactory{
    private static final Map<String, Shape1> shapes = new HashMap<>();
    public Shape1 getShape(String shapeName){
        Shape1 shape = shapes.get(shapeName);
        if(shape == null){
            switch(shapeName){
                case "circle":
                    shape = new Circle1();
                    break;
                case "square":
                    shape = new Square1();
                    break;
                case "point":
                    shape = new Point1();
                    break;
            }
            shapes.put(shapeName, shape);
        } return shape;
    }
}

