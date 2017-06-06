package car.tracker.repository;

import car.tracker.Entity.Alert;
import car.tracker.Entity.readings;
import car.tracker.Entity.tiress;

import java.util.List;

/**
 * Created by somasekhar on 5/26/2017.
 */
public interface readingsRepository {
    List<readings> findAll();
    List<readings> findByVin(String vin);
    void CreateAlert( String vin,String priority, String message);
    readings create(tiress tire, readings read);
    void delete(readings read);

}
