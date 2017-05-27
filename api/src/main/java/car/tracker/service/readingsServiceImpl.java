package car.tracker.service;

import car.tracker.Entity.Alert;
import car.tracker.Entity.readings;
import car.tracker.Entity.tiress;
import car.tracker.repository.readingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by somasekhar on 5/26/2017.
 */
@Service
public class readingsServiceImpl implements readingsService {


    @Autowired
    private readingsRepository repository;


    @Override
    public List<readings> findAll() {

        return repository.findAll();
    }

    @Override
    public readings create(readings read) {

        String message;
        Alert obj = new Alert();
       tiress tirevalue = read.getTires();


       if(tirevalue.getFrontLeft() <32 || tirevalue.getFrontLeft() >36 || tirevalue.getFrontRight() <32 || tirevalue.getFrontRight() >36
               || tirevalue.getRearLeft() <32 || tirevalue.getRearLeft() >36|| tirevalue.getRearRight() <32 || tirevalue.getRearRight() >36){
            obj.setMessage("The car tires pressure is not normal(32-36)");
           obj.setPriority("Low");
           obj.setVin(read.getVin());
           obj.setTimeStamp(new Date());
           return repository.create(tirevalue, read, obj);
       }
       else
        return repository.create(tirevalue,read);
    }

    @Override
    public void delete(String vin) {
    }
}
