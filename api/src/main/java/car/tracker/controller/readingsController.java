package car.tracker.controller;

import car.tracker.Entity.readings;
import car.tracker.service.readingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by somasekhar on 5/26/2017.
 */
@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
@RestController
@RequestMapping(value = "readings")
public class readingsController {
     @Autowired
    private readingsService service;

    @Transactional(readOnly = true)
    @RequestMapping(method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<readings> findAll(){
        return service.findAll();
    }

//    @Transactional(readOnly = true)
//    @RequestMapping(method = RequestMethod.GET, value = "{vin}",
//    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public readings findByVin(@PathVariable("vin") String vin){
//        return null;

    @Transactional
    @RequestMapping(method = RequestMethod.POST,
    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public readings create(@RequestBody readings read){
        return service.create(read);
    }

    @Transactional
    @RequestMapping(method = RequestMethod.DELETE, value = "{vin}",
    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void delete(@PathVariable("vin") String vin){
        service.delete(vin);
    }

}
