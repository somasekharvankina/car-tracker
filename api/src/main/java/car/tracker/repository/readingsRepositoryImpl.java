package car.tracker.repository;

import car.tracker.Entity.Alert;
import car.tracker.Entity.readings;
import car.tracker.Entity.tiress;
import car.tracker.Entity.vehicle;
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
    public readings create(tiress tire, readings read) {
        Alert alertobj = new Alert();

        TypedQuery<vehicle> query = em.createNamedQuery("vehicle.findByVin",vehicle.class);

        query.setParameter("pVin",read.getVin());
        if(query.getResultList().get(0).getRedlineRpm() < read.getEngineRpm()){
            alertobj.setTimeStamp(new Date());
            alertobj.setVin(read.getVin());
            alertobj.setPriority("High");
            alertobj.setMessage("Car Rpm is very high immediate attention needed");
            em.persist(alertobj);
        }

        em.persist(tire);
        em.persist(read);


        return read;
    }

//    @Override
//    public String createtire(tiress tire){
//        em.persist(tire);
//        return tire.getId() ;
//    }
    //        TypedQuery<readings> query = em.createNamedQuery("readings.insertTireValue",readings.class);
//        query.setParameter("Rid",read.getId());
//        query.setParameter("tid",tire);

    @Override
    public readings create(tiress tire, readings read,Alert obj) {
        Alert alertobj = new Alert();
        Alert alertobj1 = new Alert();


        TypedQuery<vehicle> query = em.createNamedQuery("vehicle.findByVin",vehicle.class);
        query.setParameter("pVin",read.getVin());


        if(read.getEngineRpm() > query.getResultList().get(0).getRedlineRpm()){
            alertobj.setTimeStamp(new Date());
            alertobj.setVin(read.getVin());
            alertobj.setPriority("High");
            alertobj.setMessage("Car Rpm is very high immediate attention needed");
            em.persist(alertobj);
        }
        if(read.getFuelVolume() < ((query.getResultList().get(0).getMaxFuelVolume())/10)){

            alertobj1.setTimeStamp(new Date());
            alertobj1.setMessage("Low Fuel Volume");
            alertobj1.setPriority("Medium");
            alertobj1.setVin(read.getVin());
            em.persist(alertobj1);
        }

        em.persist(tire);
        em.persist(read);
        em.persist(obj);


        return read;
    }

    @Override
    public void delete(readings reading) {
            em.remove(reading);
    }
}
