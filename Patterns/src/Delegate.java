/**
 * Created by i.bezkorovayniy on 02.08.2017.
 */
public class Delegate {

    public static void main(String[] args) {

        Painter painter = new Painter();

        painter.setGraphics(new Triangle());
        painter.draw();
        painter.setGraphics(new Square());
        painter.draw();


    }
}

    interface Graphics{
        void draw();
    }

    class Triangle implements Graphics{
        public void draw() {
            System.out.println("Draw triangle");
        }
    }

    class Circle implements Graphics{
        public void draw(){
            System.out.println("Draw circle");
        }
    }

    class Square implements Graphics{
        public void draw(){
            System.out.println("Draw square");
        }
    }

    class Painter{
        Graphics graphics;
        void setGraphics(Graphics g){
            graphics = g;
        }
        void draw(){
            graphics.draw();
        }
    }


