package car.tracker.Entity;

import javax.persistence.*;
import java.sql.Date;


@Entity

@NamedQueries({
        @NamedQuery(name = "vehicle.findAll",
                    query = "SELECT vhcl FROM vehicle vhcl ORDER BY vhcl.year ASC "),
        @NamedQuery(name = "vehicle.findByVin",
                    query = "SELECT vhcl FROM vehicle vhcl where vhcl.vin= :pVin")
})

public class vehicle {
//    @Id
//    private String  id;
//    public vehicle(){
//        this.id = UUID.randomUUID()
//                .toString();
//  }
    @Id
    private String vin;

    private String  make;
    private String model;

    @Column(length = 4)
    private int year;
    @Column(length = 5)
    private int redlineRpm;
    @Column(length = 2)
    private double maxFuelVolume;

    private Date lastServiceDate;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRedlineRpm() {
        return redlineRpm;
    }

    public void setRedlineRpm(int redlineRpm) {
        this.redlineRpm = redlineRpm;
    }

    public double getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(double maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    public Date getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(Date lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }

    @Override
    public String toString() {
        return "vehicle{" +
                "vin='" + vin + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", redlineRpm=" + redlineRpm +
                ", maxFuelVolume=" + maxFuelVolume +
                ", lastServiceDate=" + lastServiceDate +
                '}';
    }
}
