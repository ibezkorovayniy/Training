public class VisitorPattern {
    public static void main(String[] args) {
        Element body = new BodyElement();
        Element engine = new EngineElement();
        Visitor hooligan = new HooliganVisitor();
        body.accept(hooligan);
        engine.accept(hooligan);
        Visitor mechanic = new MechanicVisitor();
        body.accept(mechanic);
        engine.accept(mechanic);

    }
}
 interface Visitor{
    void visit(EngineElement engine);
    void visit(BodyElement body);
 }
 interface Element{
    void accept(Visitor visitor);
 }
 class BodyElement implements Element{
    public void accept(Visitor visitor){
        visitor.visit(this);
    }
 }
 class EngineElement implements Element{
    public void accept(Visitor visitor){
        visitor.visit(this);
    }
 }

 class HooliganVisitor implements Visitor{
     public void visit(BodyElement body) {
         System.out.println("Постукав по корпусу");
     }
     public void visit(EngineElement engine) {
         System.out.println("Завів двигун");
     }
 }

 class MechanicVisitor implements Visitor{
     public void visit(EngineElement engine) {
         System.out.println("Check the engine");
     }
     public void visit(BodyElement body) {
         System.out.println("Відполірував кузов");
     }
 }