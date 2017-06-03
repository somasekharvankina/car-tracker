package car.tracker.service;

import car.tracker.Entity.vehicle;

import java.util.List;


public interface vehicleService {
	
    List<vehicle>  findAll();
    vehicle create(vehicle[] vhcl);
    void delete(String para);
}
