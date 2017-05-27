package car.tracker.Entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

/**
 * Created by somasekhar on 5/26/2017.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "readings.findAll",
                    query = "select reading FROM readings reading ORDER BY reading.vin ASC"),
        @NamedQuery(name = "readings.findByVin",
                    query = "SELECT  reading FROM  readings reading WHERE reading.vin = :pVin")
})
public class readings {


    @Id
    private String id;
    public readings(){
        this.id = UUID.randomUUID()
                .toString();
    }
    
    private String vin;

    private Float latitude;
    private Float longitude;

    private Date  timestamp;
    
    private double fuelVolume;
    private int speed;
    private int engineHp;

    private Boolean checkEngineLightOn;
    private Boolean engineCoolantLow;
    private Boolean cruiseControlOn;

    @Column(length = 5)
    private int engineRpm;

    @OneToOne
    private tiress tires;


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

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public double getFuelVolume() {
        return fuelVolume;
    }

    public void setFuelVolume(double fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getEngineHp() {
        return engineHp;
    }

    public void setEngineHp(int engineHp) {
        this.engineHp = engineHp;
    }

    public Boolean getCheckEngineLightOn() {
        return checkEngineLightOn;
    }

    public void setCheckEngineLightOn(Boolean checkEngineLightOn) {
        this.checkEngineLightOn = checkEngineLightOn;
    }

    public Boolean getEngineCoolantLow() {
        return engineCoolantLow;
    }

    public void setEngineCoolantLow(Boolean engineCoolantLow) {
        this.engineCoolantLow = engineCoolantLow;
    }

    public Boolean getCruiseControlOn() {
        return cruiseControlOn;
    }

    public void setCruiseControlOn(Boolean cruiseControlOn) {
        this.cruiseControlOn = cruiseControlOn;
    }

    public int getEngineRpm() {
        return engineRpm;
    }

    public void setEngineRpm(int engineRpm) {
        this.engineRpm = engineRpm;
    }

    public tiress getTires() {
        return tires;
    }

    public void setTires(tiress tires) {
        this.tires = tires;
    }
}



