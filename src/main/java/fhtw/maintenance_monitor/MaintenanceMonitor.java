package fhtw.maintenance_monitor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaintenanceMonitor {

    @GetMapping("/api/hello")
    public String hello()
    {
        return"Hello World!";
    }

}
