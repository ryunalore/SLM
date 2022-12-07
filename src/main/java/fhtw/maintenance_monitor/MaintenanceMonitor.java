package fhtw.maintenance_monitor;

import org.springframework.data.annotation.Id;

public class MaintenanceMonitor {

    private String message_default = "Everything operates as expected";         // This is the default message, which can be defined here.
    private String message_current = message_default;                           // Initiate with default message.

    // constructor
    public MaintenanceMonitor(){
        this.message_current = getMessage_current();
    }

    /*
    public void setMessage_current(String message_current) {
        this.message_current = message_current;
    }
     */

    public String getMessage_current() {
        return message_current;
    }

    public String message_set(String m) {
        this.message_current = m.replace('+', ' ');
        //this.message_current.replace('+',' ');
        return "ok";
    }

    public String message_reset() {
        this.message_current = message_default;
        return "ok";
    }

}
