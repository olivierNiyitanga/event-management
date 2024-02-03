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
public class attendee {
    private String attendeeid;
    private String venueid;
    private String userid;

    public attendee() {
    }

    public attendee(String attendeeid, String venueid, String userid) {
        this.attendeeid = attendeeid;
        this.venueid = venueid;
        this.userid = userid;
    }

    public String getAttendeeid() {
        return attendeeid;
    }

    public String getVenueid() {
        return venueid;
    }

    public String getUserid() {
        return userid;
    }

    public void setAttendeeid(String attendeeid) {
        this.attendeeid = attendeeid;
    }

    public void setVenueid(String venueid) {
        this.venueid = venueid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
    
}
