package com.sai.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Alert {

    @Id
    private String id;

    private String vin;
    private String priority;
    private String message;

    public Alert(String vin, String priority, String message){
        this.vin = vin;
        this.priority = priority;
        this.message = message;
        this.id = UUID.randomUUID().toString();
    }

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

    @Override
    public String toString() {
        return "Alert{" +
                "id=" + id +
                ", vin='" + vin + '\'' +
                ", priority='" + priority + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
