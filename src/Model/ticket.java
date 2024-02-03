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
public class ticket {
 private String ticketid;
 private String eventid;
 private String ticketname;
 private String tickettype; 
 private double price;

    public ticket() {
    }

    public ticket(String ticketid, String eventid, String ticketname,String tickettype, double price) {
        this.ticketid = ticketid;
        this.eventid = eventid;
        this.ticketname = ticketname;
        this.tickettype=tickettype;
        this.price = price;
        
    }

    public String getTicketid() {
        return ticketid;
    }

    public String getEventid() {
        return eventid;
    }

    public String getTicketname() {
        return ticketname;
    }
   public String getTickettype() {
        return tickettype;
    }

    public double getPrice() {
        return price;
    }

    public void setTicketid(String ticketid) {
        this.ticketid = ticketid;
    }

    public void setEventid(String eventid) {
        this.eventid = eventid;
    }

    public void setTicketname(String ticketname) {
        this.ticketname = ticketname;
    }
   public void setTickettype(String tickettype) {
        this.tickettype = tickettype;
    }

    public void setPrice(double price) {
        this.price = price;
    }

  
 
}
