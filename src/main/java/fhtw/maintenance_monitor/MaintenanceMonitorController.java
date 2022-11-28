package fhtw.maintenance_monitor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaintenanceMonitorController {

    private  MaintenanceMonitor monitor = new MaintenanceMonitor();

    /*
    // test code
    @GetMapping("/api/maintenancemonitor")
    public long addNumbers(@RequestParam(name="numberOne") int numberOne, @RequestParam(name="numberTwo") int numberTwo){
        return monitor.add(numberOne,numberTwo);
    }
     */

    @GetMapping("/api/message")
    public String message(){
        return monitor.getMessage_current();
    }

    @PutMapping("/api/message/set")
    public String message_set(@RequestParam(name="m") String m) {
        return monitor.message_set(m);
    }

    @PutMapping("/api/message/reset")
    public String message_reset() {
        return monitor.message_reset();
    }
}
