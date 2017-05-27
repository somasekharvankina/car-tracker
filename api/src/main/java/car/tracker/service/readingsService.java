package car.tracker.service;

import car.tracker.Entity.readings;

import java.util.List;

/**
 * Created by somasekhar on 5/26/2017.
 */
public interface readingsService {

    List<readings> findAll();
    readings create(readings reading);
    void delete(String vin);
}
