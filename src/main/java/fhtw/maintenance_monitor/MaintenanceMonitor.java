package fhtw.maintenance_monitor;

public class MaintenanceMonitor {



    private String message_current = "Everything works as expected";

    // constructor
    public MaintenanceMonitor(){
        this.message_current = getMessage_current();
    }


    public void setMessage_current(String message_current) {
        this.message_current = message_current;
    }

    public String getMessage_current() {
        return message_current;
    }

    public String message_set(String m) {
        this.message_current = m.replace('+', ' ');
        return "ok";
    }

    public String message_reset() {
        this.message_current ="Everything works as expected";
        return "ok";
    }

    /*
    // test code
    public long add(int numberOne, int numberTwo){
        return numberOne + numberTwo;
    }
     */

}
