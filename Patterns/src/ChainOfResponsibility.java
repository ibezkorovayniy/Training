public class ChainOfResponsibility {
    public static void main(String[] args) {
        SMSLogger logger0 = new SMSLogger(Level.ERROR);
        FileLogger logger1 = new FileLogger(Level.DEBUG);
        MailLogger logger2 = new MailLogger(3);
        logger0.setNext(logger1);
        logger1.setNext(logger2);
        logger0.WriteMessage("All is good", 3);
        logger0.WriteMessage("Somthing is bad", 1);
        logger0.WriteMessage("Debugging...", 2);
    }
}

class Level{
    public static final int ERROR = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
}
abstract class Logger{
    int priority;
    public Logger(int priority) {
        this.priority = priority;
    }
    Logger next;
    public void setNext(Logger next) {
        this.next = next;
    }
    public void WriteMessage(String message, int level){
        if (level <= priority) {
            write(message);
        }
        if (next != null) {
            next.WriteMessage(message, level);
        }
    }
    abstract void write(String message);
}

class SMSLogger extends Logger {
    public SMSLogger(int priority) {
        super(priority);
    }
    public void write(String message){
        System.out.println("SMS: " + message);
    }
}
class FileLogger extends Logger{
        public FileLogger(int priority) {
            super(priority);
        }
        public void write(String message){
            System.out.println("Writing into file: " + message);
        }
}
class MailLogger extends Logger{
    public MailLogger(int priority) {
        super(priority);
    }
    public void write(String message){
        System.out.println("Sending e-mail: " + message);
    }
}
