/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.venue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rocky
 */
public class venueDao {
     private String dbUrl="jdbc:postgresql://localhost:5432/Event_management";
    private String username="postgres";
    private String passwd="OLIVIER";

    public venueDao() {
    }
      public String registerVenue(venue venueObj){
    try {
        // Create Connection
        Connection con = DriverManager.getConnection(dbUrl, username, passwd);
        // Create Statement
        String sql = "insert into venue (venue_id, venue_name,address,capacity) values (?, ?, ?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, Integer.parseInt(venueObj.getVenueid()));
        pst.setString(2, venueObj.getVenuename());
         pst.setString(3, venueObj.getAddress());
        pst.setInt(4, Integer.parseInt(venueObj.getCapacity()));
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
      public venue searchVenue(venue venueObj){
    try {
        Connection con = DriverManager.getConnection(dbUrl, username, passwd);
        String sql ="select * from venue where venue_id=?";
        PreparedStatement pst = con.prepareStatement(sql);
        
        // Assuming venue_id is of type integer
        pst.setInt(1, Integer.parseInt(venueObj.getVenueid()));
        
        ResultSet result = pst.executeQuery();
        venue thevenue = new venue();
        boolean found = false;

        if (result.next()) {
            thevenue.setVenueid(result.getString("venue_id"));
            thevenue.setVenuename(result.getString("venue_name"));
            thevenue.setAddress(result.getString("address"));
            thevenue.setCapacity(result.getString("capacity"));
            found = true;
        }

        con.close();

        if (found) {
            return thevenue;
        }
    } catch(Exception ex) {
        ex.printStackTrace();
    }
    return null;
}
 public String updateVenue(venue venueObj){
        try{
            // Create Connection
            Connection con = DriverManager.getConnection(dbUrl, username, passwd);
            // Create Statement
            String sql ="update venue set venue_name=?,address=? ,capacity=? where venue_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
             pst.setInt(4, Integer.parseInt(venueObj.getVenueid()));
            pst.setString(1, venueObj.getVenuename());
              pst.setString(2, venueObj.getAddress());
             pst.setInt(3, Integer.parseInt(venueObj.getCapacity()));

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
     public String deletevenue(venue venueObj){
        try{
            // Create Connection
            Connection con = DriverManager.getConnection(dbUrl, username, passwd);
            // Create Statement
            String sql ="delete from venue where venue_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(venueObj.getVenueid()));
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
     
     
 public List<venue> allvenues() {
    List<venue> venues = new ArrayList<>();

    try (Connection con = DriverManager.getConnection(dbUrl, username, passwd);
         PreparedStatement pst = con.prepareStatement("SELECT * FROM venue");
         ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {
            venue venueObj = new venue();
            venueObj.setAddress(rs.getString("address"));
            venueObj.setCapacity(rs.getString("capacity"));
            venueObj.setVenueid(rs.getString("venue_id"));
            venueObj.setVenuename(rs.getString("venue_name"));
            venues.add(venueObj);
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return venues;
}
}
