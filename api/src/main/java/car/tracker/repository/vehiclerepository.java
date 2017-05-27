package car.tracker.repository;

import car.tracker.Entity.vehicle;

import java.util.List;

/**
 * Created by somasekhar on 5/25/2017.
 */
public interface vehiclerepository {
    List<vehicle> findAll();
    vehicle findByVin(String vin);
    void create(vehicle vcl);
    void update(vehicle vcl);
    void delete(vehicle para);
}
