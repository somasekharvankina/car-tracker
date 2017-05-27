package car.tracker.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

/**
 * Created by somasekhar on 5/27/2017.
 */
@Entity
public class Alert {

    @Id
private  String id;

    public Alert(){
        this.id = UUID.randomUUID()
                .toString();
    }

private  String vin;
private String message;
private Date timeStamp ;
private  String priority;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Alert{" +
                "id='" + id + '\'' +
                ", vin='" + vin + '\'' +
                ", message='" + message + '\'' +
                ", timeStamp=" + timeStamp +
                ", priority='" + priority + '\'' +
                '}';
    }
}
