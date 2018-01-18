package com.sai.entity;

public class HighAlert {

    private String vin;
    private Integer count;

    public HighAlert(String vin, Integer count) {
        this.vin = vin;
        this.count = count;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "HighAlert{" +
                "vin='" + vin + '\'' +
                ", count=" + count +
                '}';
    }
}
