/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.user;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Rocky
 */
public class userDao {
    private String dbUrl="jdbc:postgresql://localhost:5432/Event_management";
    private String username="postgres";
    private String passwd="OLIVIER"; 

    public userDao() {
    }
      public String registerUser(user userObj){
    try {
        // Create Connection
        Connection con = DriverManager.getConnection(dbUrl, username, passwd);
        // Create Statement
        String sql = "insert into users (user_id, user_name,email,role,event) values ( ?,?,?, ?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, Integer.parseInt(userObj.getUserid()));
        pst.setString(2, userObj.getUsername());
         pst.setString(3, userObj.getEmail());
         pst.setString(4, userObj.getRole());
         pst.setString(5, userObj.getEvent());
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
      public user searchUser(user userObj){
    try {
        Connection con = DriverManager.getConnection(dbUrl, username, passwd);
        String sql ="select * from users where user_id=?";
        PreparedStatement pst = con.prepareStatement(sql);
        
        // Assuming user_id is of type integer
        pst.setInt(1, Integer.parseInt(userObj.getUserid()));
        
        ResultSet result = pst.executeQuery();
        user theuser = new user();
        boolean found = false;

        if (result.next()) {
            theuser.setUserid(result.getString("user_id"));
            theuser.setUsername(result.getString("user_name"));
            theuser.setEmail(result.getString("email"));
            theuser.setRole(result.getString("role"));
            theuser.setEvent(result.getString("event"));
            found = true;
        }

        con.close();

        if (found) {
            return theuser;
        }
    } catch(Exception ex) {
        ex.printStackTrace();
    }
    return null;
}
 public String updateUser(user userObj){
        try{
            // Create Connection
            Connection con = DriverManager.getConnection(dbUrl, username, passwd);
            // Create Statement
            String sql ="update users set user_name=?,email=?,role=?,event=?  where user_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
             pst.setInt(5, Integer.parseInt(userObj.getUserid()));
            pst.setString(1, userObj.getUsername());
              pst.setString(2, userObj.getEmail());
             pst.setString(3, userObj.getRole());
             pst.setString(4, userObj.getEvent());

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
     public String deleteUser(user userObj){
        try{
            // Create Connection
            Connection con = DriverManager.getConnection(dbUrl, username, passwd);
            // Create Statement
            String sql ="delete from users where user_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(userObj.getUserid()));
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
