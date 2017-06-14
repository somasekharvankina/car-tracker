package car.tracker.service;

import car.tracker.Entity.readings;

import java.util.Date;
import java.util.List;

/**
 * Created by somasekhar on 5/26/2017.
 */
public interface readingsService {

    List<readings> findAll();
    List<readings> findOne(String Vin);
    readings create(readings reading);
    List<readings> findLatest(String vin, int latest);
    List<readings> findByTime(String vin, long From, long To);
    void delete(String vin);
}
