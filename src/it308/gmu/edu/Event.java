/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it308.gmu.edu;

import java.util.Date;

/**
 *
 * @author gabrielquerbes
 */
public class Event {
    //a unique ID, description, event date, address, city, state, zip code, and a Boolean delete indicator. 

    private String id;
    private String description;
    private Date date;
    private String address;
    private String city;
    private String state;
    private String zip;
    private boolean delete;

    public Event(String id, String descritpion, Date date, String address, String city, String state, String zip, boolean delete) {
        this.id = id;
        this.description = descritpion;
        this.date = date;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.delete = delete;
    }

    Event() {
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String descritpion) {
        this.description = descritpion;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public Object getValue(int i) {
        switch (i) {
            case 0:
                return id;
            case 1:
                return description;
            case 2:
                return date;
            case 3:
                return address;
            case 4:
                return city;
            case 5:
                return state;
            case 6:
                return zip;
            case 7:
                return delete;

        }
        return "";
     }
    
}
