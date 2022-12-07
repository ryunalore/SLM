package fhtw.maintenance_monitor;

import org.springframework.web.bind.annotation.*;

@RestController
public class MaintenanceMonitorController {

    private  MaintenanceMonitor monitor = new MaintenanceMonitor();

      @GetMapping("/api/message")
    public String message(){

        return monitor.getMessage_current();
    }

    @RequestMapping("/api/message/set")
    public String message_set(@RequestParam(name="m") String m) {
        return monitor.message_set(m);
    }

    @RequestMapping("/api/message/reset")
    public String message_reset() {
        return monitor.message_reset();
    }

    @RequestMapping("/api/example")
    public String example()
    {
        return "example";
    }
}
