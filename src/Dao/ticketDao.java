/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.ticket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

/**
 *
 * @author Rocky
 */
public class ticketDao {
    private String dbUrl="jdbc:postgresql://localhost:5432/Event_management";
    private String username="postgres";
    private String passwd="OLIVIER"; 

    public ticketDao() {
    }
     public String registerTicket(ticket ticketObj){
    try {
        // Create Connection
        Connection con = DriverManager.getConnection(dbUrl, username, passwd);
        // Create Statement
        String sql = "insert into ticket (ticket_id,event_id ,ticket_name,Ticket_type,price) values (?,?, ?, ?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, Integer.parseInt(ticketObj.getTicketid()));
      pst.setInt(2, Integer.parseInt(ticketObj.getEventid()));
        pst.setString(3, ticketObj.getTicketname());
         pst.setString(4, ticketObj.getTickettype());
         pst.setDouble(5, ticketObj.getPrice());
        int rowAffected = pst.executeUpdate();
        con.close();
        if (rowAffected >= 1) {
            return "Data Saved Successfully";
        } else {
            return "Data Not Saved";
        }
    } catch (Exception ex) {
        ex.printStackTrace();
        return "Server Error";
    }
}
      public ticket searchTicket(ticket ticketObj){
    try {
        Connection con = DriverManager.getConnection(dbUrl, username, passwd);
        String sql ="select * from ticket where ticket_id=?";
        PreparedStatement pst = con.prepareStatement(sql);
        
        // Assuming ticket_id is of type integer
        pst.setInt(1, Integer.parseInt(ticketObj.getTicketid()));
        
        ResultSet result = pst.executeQuery();
        ticket theticket = new ticket();
        boolean found = false;

        if (result.next()) {
            theticket.setTicketid(result.getString("ticket_id"));
            theticket.setEventid(result.getString("event_id"));
            theticket.setTicketname(result.getString("ticket_name"));
            theticket.setTickettype(result.getString("ticket_type"));
            theticket.setPrice(result.getDouble("price"));
            found = true;
        }

        con.close();

        if (found) {
            return theticket;
        }
    } catch(Exception ex) {
        ex.printStackTrace();
    }
    return null;
}
 public String updateTicket(ticket ticketObj){
        try{
            // Create Connection
            Connection con = DriverManager.getConnection(dbUrl, username, passwd);
            // Create Statement
            String sql ="update ticket set event_id=?, ticket_name=?,tickettype=?,price=? where ticket_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
             pst.setInt(5, Integer.parseInt(ticketObj.getTicketid()));
            pst.setInt(1, Integer.parseInt(ticketObj.getEventid()));
            pst.setString(2, ticketObj.getTicketname());
              pst.setString(3, ticketObj.getTickettype());
              pst.setDouble(4, ticketObj.getPrice());

            // execute Statement
            int rowAffected = pst.executeUpdate();
            // close connection
            con.close();
            if(rowAffected >=1){
//               con.close();
               return "Data Update Successful";
            }else{
//                con.close();
               return "Data Not Updated";
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
            return "Server Error";
        }
//        return "Server Error";
    }
     public String deleteTicket(ticket ticketObj){
        try{
            // Create Connection
            Connection con = DriverManager.getConnection(dbUrl, username, passwd);
            // Create Statement
            String sql ="delete from ticket where ticket_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(ticketObj.getTicketid()));
            // execute Statementge
            int rowAffected = pst.executeUpdate();
            // close connection
            con.close();
            if(rowAffected >=1){
//               con.close();
               return "Data Deleted Successful";
            }else{
//                con.close();
               return "Data Not Deleted";
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
            return "Server Error";
        }
//        return "Server Error";
    }

}
