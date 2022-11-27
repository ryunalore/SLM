package fhtw.maintenance_monitor;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaintenanceMonitorController {

    private  MaintenanceMonitor monitor = new MaintenanceMonitor();

    @GetMapping("/api/maintenancemonitor")
    public long addNumbers(@RequestParam(name="numberOne") int numberOne, @RequestParam(name="numberTwo") int numberTwo){
        return monitor.add(numberOne,numberTwo);
    }
}
