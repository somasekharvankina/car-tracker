package car.tracker.repository;

import car.tracker.Entity.vehicle;
import org.hibernate.annotations.Persister;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by somasekhar on 5/25/2017.
 */
@Repository
public class vehiclerepositoryImpl implements vehiclerepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<vehicle> findAll() {
        TypedQuery<vehicle> query = em.createNamedQuery("vehicle.findAll",vehicle.class);
        return query.getResultList();
    }

    @Override
    public vehicle findByVin(String vin) {
        TypedQuery<vehicle> query = em.createNamedQuery("vehicle.findByVin",vehicle.class);
        query.setParameter("pVin",vin);
        List<vehicle> result = query.getResultList();
        if(result != null && result.size()==1){
        return result.get(0);
        }
        else
            return null;
    }

    @Override
    public void create(vehicle vhcl) {
        em.persist(vhcl);
    }

    @Override
    public void update(vehicle vhcl) {

         em.merge(vhcl);
    }

    @Override
    public void delete(vehicle para) {
            em.remove(para);
    }
}
