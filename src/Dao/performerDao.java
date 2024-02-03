/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.performer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Rocky
 */
public class performerDao {
    private String dbUrl="jdbc:postgresql://localhost:5432/Event_management";
    private String username="postgres";
    private String passwd="OLIVIER"; 

    public performerDao() {
    }
      public String registerPerformer(performer performerObj){
    try {
        // Create Connection
        Connection con = DriverManager.getConnection(dbUrl, username, passwd);
        // Create Statement
        String sql = "insert into performer (performer_id, performer_name,type) values ( ?, ?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, Integer.parseInt(performerObj.getPerformerid()));
        pst.setString(2, performerObj.getPerformername());
         pst.setString(3, performerObj.getType());
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
      public performer searchPerformer(performer performerObj){
    try {
        Connection con = DriverManager.getConnection(dbUrl, username, passwd);
        String sql ="select * from performer where performer_id=?";
        PreparedStatement pst = con.prepareStatement(sql);
        
        // Assuming performer_id is of type integer
        pst.setInt(1, Integer.parseInt(performerObj.getPerformerid()));
        
        ResultSet result = pst.executeQuery();
        performer theperformer = new performer();
        boolean found = false;

        if (result.next()) {
            theperformer.setPerformerid(result.getString("performer_id"));
            theperformer.setPerformername(result.getString("performer_name"));
            theperformer.setType(result.getString("type"));
            found = true;
        }

        con.close();

        if (found) {
            return theperformer;
        }
    } catch(Exception ex) {
        ex.printStackTrace();
    }
    return null;
}
 public String updatePerformer(performer performerObj){
        try{
            // Create Connection
            Connection con = DriverManager.getConnection(dbUrl, username, passwd);
            // Create Statement
            String sql ="update performer set performer_name=?,type=?  where performer_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
             pst.setInt(4, Integer.parseInt(performerObj.getPerformerid()));
            pst.setString(1, performerObj.getPerformername());
              pst.setString(2, performerObj.getType());

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
     public String deletePerformer(performer performerObj){
        try{
            // Create Connection
            Connection con = DriverManager.getConnection(dbUrl, username, passwd);
            // Create Statement
            String sql ="delete from performer where performer_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(performerObj.getPerformerid()));
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
