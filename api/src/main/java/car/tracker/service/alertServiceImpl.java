package car.tracker.service;

import car.tracker.Entity.Alert;
import car.tracker.repository.alertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * Created by somasekhar on 6/6/2017.
 */
@Service
public class alertServiceImpl implements alertService {

    @Autowired
    private alertRepository repository;

    @Override
    public List<Alert> findAll() {

        return repository.findAll();
    }

    @Override
    public List<Alert> findOne(String vin) {
        return repository.findOne(vin);
    }

    @Override
    public List<Alert> findByDate() {
        Date past = new Date(System.currentTimeMillis() - 7200*1000);
        return repository.findByDate(past);

    }
}
