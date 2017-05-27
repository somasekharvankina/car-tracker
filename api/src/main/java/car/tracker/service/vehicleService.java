package car.tracker.service;

import car.tracker.Entity.vehicle;

import java.util.List;

/**
 * Created by somasekhar on 5/25/2017.
 */
public interface vehicleService {
    List<vehicle>  findAll();
    vehicle create(vehicle[] vhcl);
    void delete(String para);
}
