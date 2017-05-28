package car.tracker.service;

import car.tracker.Entity.vehicle;
import car.tracker.repository.vehiclerepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import javax.sound.midi.Soundbank;
import java.util.List;

/**
 * Created by somasekhar on 5/25/2017.
 */
@Service

public class vehicleServiceImpl implements vehicleService {

    @Autowired
    private vehiclerepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<vehicle> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public vehicle create(vehicle[] vhcl) {
        for (int i =0; i<vhcl.length;i++) {
            vehicle vcl = vhcl[i];
            vehicle result = repository.findByVin(vcl.getVin());
            if (result == null) {
                repository.create(vcl);
            }
            else {

                repository.update(vcl);
            }
        }
        return null;
    }

    @Override
    @Transactional
    public void delete(String para) {

        vehicle result = repository.findByVin(para);
        if (result != null) {
            repository.delete(result);
        }
    }
}