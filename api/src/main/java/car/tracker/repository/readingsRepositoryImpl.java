package car.tracker.repository;

import car.tracker.Entity.Alert;
import car.tracker.Entity.readings;
import car.tracker.Entity.tiress;
import car.tracker.Entity.vehicle;
import car.tracker.Exceptions.BadRequestException;
import car.tracker.Exceptions.NotFoundExceptions;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

/**
 * Created by somasekhar on 5/26/2017.
 */
@Repository
public class readingsRepositoryImpl implements readingsRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<readings> findAll() {
        TypedQuery<readings> query = em.createNamedQuery("readings.findAll",readings.class);
        if(query == null){
            throw new BadRequestException("No data found");
        }
        List<readings> result =  query.getResultList();
        return query.getResultList();
    }

    @Override
    public List<readings> findByVin(String vin) {
        TypedQuery<readings> query = em.createNamedQuery("readings.findByVin", readings.class);
        query.setParameter("pVin",vin);
        return query.getResultList();
    }

    @Override
    public void CreateAlert(String vin, String priority, String Message) {
        Alert object = new Alert();
        object.setMessage(Message);
        object.setPriority(priority);
        object.setVin(vin);
        object.setTimeStamp(new Date());
        em.persist(object);
    }

    @Override
    public readings create(tiress tire, readings read) {

        TypedQuery<vehicle> query = em.createNamedQuery("vehicle.findByVin",vehicle.class);

        query.setParameter("pVin",read.getVin());

        if(query.getResultList().get(0).getRedlineRpm() < read.getEngineRpm()){
            CreateAlert(read.getVin(),"High","Attention needed! Car RPM is very High");
        }

        if(read.getFuelVolume() < ((query.getResultList().get(0).getMaxFuelVolume())/10)){

            CreateAlert(read.getVin(),"Medium","Warning: Fuel is Low!");
        }

        em.persist(tire);
        em.persist(read);

        return read;
    }


    @Override
    public void delete(readings reading) {
            em.remove(reading);
    }
}
