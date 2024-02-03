/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Rocky
 */
public class venue {
    private String venueid;
    private String venuename;
    private String address;
    private String capacity;

    public venue() {
    }

    public venue(String venueid, String venuename, String address, String capacity) {
        this.venueid = venueid;
        this.venuename = venuename;
        this.address = address;
        this.capacity = capacity;
    }

    public String getVenueid() {
        return venueid;
    }

    public String getVenuename() {
        return venuename;
    }

    public String getAddress() {
        return address;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setVenueid(String venueid) {
        this.venueid = venueid;
    }

    public void setVenuename(String venuename) {
        this.venuename = venuename;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }
    
}
