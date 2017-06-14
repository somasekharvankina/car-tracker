package car.tracker.repository;

import car.tracker.Entity.Alert;
import car.tracker.Exceptions.NotFoundExceptions;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * Created by somasekhar on 6/6/2017.
 */
@Repository
public class alertRepositoryImpl implements alertRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Alert> findAll() {
        TypedQuery<Alert> query = em.createNamedQuery("alert.findAll",Alert.class);
        if(query ==  null){
            throw new NotFoundExceptions("No data Found");
        }
        return query.getResultList();
    }

    @Override
    public List<Alert> findOne(String vin) {

        TypedQuery<Alert> query = em.createNamedQuery("alert.findByVin",Alert.class);
        query.setParameter("pVin",vin);
        if(query == null){
            throw  new NotFoundExceptions("No data Found");
        }
        return query.getResultList();
      }

    @Override
    public List<Alert> findByDate(Date time) {

        TypedQuery<Alert> query = em.createNamedQuery("alert.findByDate",Alert.class );
        query.setParameter("past",time);
        if(query == null){
            throw new NotFoundExceptions("No data found");
        }
        return query.getResultList();
    }
}
