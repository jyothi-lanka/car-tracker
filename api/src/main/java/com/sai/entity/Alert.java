package com.sai.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@NamedQueries({ @NamedQuery(name="Alert.findByVin",
                            query = "SELECT a from Alert a where a.vin=:paramVin")})
public class Alert {

    @Id
    private String id;

    private String vin;
    private String priority;
    private String message;
    private Date createdDate;

    public Alert(String vin, String priority, String message){
        this.vin = vin;
        this.priority = priority;
        this.message = message;
        this.id = UUID.randomUUID().toString();
        this.createdDate = new Date();
    }

    public Alert(){}

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

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Alert{" +
                "id='" + id + '\'' +
                ", vin='" + vin + '\'' +
                ", priority='" + priority + '\'' +
                ", message='" + message + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
