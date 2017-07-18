package car.tracker.service;

import car.tracker.Entity.Alert;

import java.util.List;

/**
 * Created by somasekhar on 6/6/2017.
 */
public interface alertService {
    List<Alert> findAll();
    List<Alert> findOne(String vin);
    List<Alert> findByDate();
}
