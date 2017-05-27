package car.tracker.controller;

import car.tracker.Entity.vehicle;
import car.tracker.service.vehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PersistenceContext;
import java.awt.*;
import java.util.List;

@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
@RestController
@RequestMapping(value = "vehicles")

public class vehicleController {

    @Autowired
    private vehicleService service;


    @RequestMapping(method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<vehicle> findAll(){
        return service.findAll() ;
    }


    @RequestMapping(method = RequestMethod.PUT,
                    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
                    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public vehicle create(@RequestBody vehicle[] vcl){
        return service.create(vcl);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "{id}")
    public void delete(@PathVariable("id") String para){
         service.delete(para);
    }
}
