package car.tracker.repository;

import car.tracker.Entity.Alert;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * Created by somasekhar on 6/6/2017.
 */

public interface alertRepository {
    List<Alert> findAll();
    List<Alert> findOne(String vin);
    List<Alert> findByDate(Date time);
}
