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
public class user {
  private String userid;
private  String username;
private String email;
private String role;
private  String event;

   


    public user() {
    }

    public user(String userid, String username, String email, String role) {
        this.userid = userid;
        this.username = username;
        this.email = email;
        this.role = role;
    }

    public String getUserid() {
        return userid;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }
     public String getEvent() {
        return event;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }
       public void setEvent(String event) {
        this.event = event;
    }


}
