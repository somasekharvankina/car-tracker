package car.tracker.service;

import car.tracker.Entity.Alert;
import car.tracker.Entity.readings;
import car.tracker.Entity.tiress;
import car.tracker.Exceptions.BadRequestException;
import car.tracker.Exceptions.NotFoundExceptions;
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
    public List<readings> findOne(String vin) {
        return repository.findByVin(vin);
    }

    @Override
    public readings create(readings read) {
        if (read != null) {
            StringBuilder message = new StringBuilder("");
            tiress tirevalue = read.getTires();

            if (tirevalue.getFrontLeft() < 32 || tirevalue.getFrontLeft() > 36){
                message.append("Front left tire pressure is not Normal. ");
            }
            if(tirevalue.getFrontRight() < 32 || tirevalue.getFrontRight() > 36){
                message.append("Front Right tire pressure is not normal. ");
            }
            if(tirevalue.getRearLeft() < 32 || tirevalue.getRearLeft() > 36 ) {
                message.append("Rear Left tire pressure is not normal. ");
            }
            if(tirevalue.getRearRight() < 32 || tirevalue.getRearRight() > 36) {
                message.append("Rear Right tire pressure is not normal. ");
            }
            if(message.length() >4) {
                repository.CreateAlert(read.getVin(),"Low",message.toString());
            }
                if (read.getCheckEngineLightOn() || read.getEngineCoolantLow()) {

                    repository.CreateAlert(read.getVin(), "Low", "Soon attention needed for CheckEngine or Engine Coolant");

                }

                return repository.create(tirevalue, read);

            } else
                throw new BadRequestException("No data found in " + read);
        }

    @Override
    public List<readings> findLatest(String vin, int latest) {
        if(vin!= null){
            List<readings> result = repository.findByVin(vin);
            if(result != null){
                return repository.findLatest(vin,latest);
            }
            else{
                throw new NotFoundExceptions("Bad parameters");
            }
        }
        throw  new BadRequestException("Vin should be defined");
    }

    @Override
    public List<readings> findByTime(String vin, long From,long To) {
        List<readings> result = repository.findByVin(vin);
        Date newFrom = new Date(From);
        Date newTo = new Date(To);
        if(result!= null){
           return repository.findByTime(vin,newFrom,newTo);
        }
        throw new BadRequestException("No data found") ;
    }


    @Override
    public void delete(String vin) {

        List<readings> result = repository.findByVin(vin);

        if(result!= null){
            repository.delete(result.get(0));
            }
        else{
        throw  new NotFoundExceptions("no data found on the Vin" + vin);
           }
        }
    }

