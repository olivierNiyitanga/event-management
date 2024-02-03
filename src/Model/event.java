/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Rocky
 */
public class event {
   private  String eventid;
   private String eventname;
   private String date;

    public event() {
    }

    public event(String eventid, String eventname, String date) {
        this.eventid = eventid;
        this.eventname = eventname;
        this.date = date;
    }

    public String getEventid() {
        return eventid;
    }

    public String getEventname() {
        return eventname;
    }

    public String getDate() {
        return date;
    }

    public void setEventid(String eventid) {
        this.eventid = eventid;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public void setDate(String date) {
        this.date = date;
    }
   
}
