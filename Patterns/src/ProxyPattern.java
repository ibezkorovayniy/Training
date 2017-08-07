public class ProxyPattern {
    public static void main(String[] args) {
        Image image = new ProxyImage("D://someDirectory/SomeFile");
        image.display();


    }
}
interface Image{
     void display();
}
class RealImage implements Image{
    String file;
    public RealImage(String file){
    this.file = file;
    load();
    }
    void load(){
        System.out.println("Image loading..." + file);
    }
    public void display() {
        System.out.println("Watching the File");
    }
}
class ProxyImage implements Image{
    RealImage image;
    String file;
    public ProxyImage(String file){
        this.file = file;
    }
    public void display(){
        if(image == null){
            image = new RealImage(file);
        }
        image.display();
    }
}