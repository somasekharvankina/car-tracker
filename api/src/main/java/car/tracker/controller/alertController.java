package car.tracker.controller;

import car.tracker.Entity.Alert;
import car.tracker.service.alertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by somasekhar on 6/6/2017.
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "alerts")
public class alertController {

    @Autowired
    private alertService service;

    @Transactional(readOnly = true)
    @RequestMapping(method= RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
    public List<Alert> findAll(){
        return service.findAll();
    }

    @Transactional(readOnly = true)
    @RequestMapping(method = RequestMethod.GET, value = {"dummy/latest"},
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Alert> findByDate(){return service.findByDate();}

    @Transactional(readOnly = true)
    @RequestMapping(method = RequestMethod.GET, value = "{vin}",
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Alert> findOne(@PathVariable("vin") String vin){
        return service.findOne(vin);
    }
}
