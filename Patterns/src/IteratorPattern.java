public class IteratorPattern {
    public static void main(String[] args) {
        ConcreteAgregate c = new ConcreteAgregate();
        Iterator it = c.getIterator();
        while(it.hasNext()){
            System.out.println((String)it.next());
        }
    }
}
interface Iterator{
    boolean hasNext();
    Object next();
}
interface Aggregate{
    Iterator getIterator();
}

class ConcreteAgregate implements Aggregate {
    String[] tasks = {"To build a house", "To born a sun", "To put a tree"};
    public Iterator getIterator() {
        return new TaskIterator();
    }
    private class TaskIterator implements Iterator {
        int index = 0;
        public boolean hasNext() {
            if(index < tasks.length){
                return true;
            }
            return false;
        }
        public Object next(){
            return tasks[index++];
        }
    }
}