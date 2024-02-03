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
public class performer {
 private String performerid;
 private String performername;
 private String type;

    public performer() {
    }

    public performer(String performerid, String performername, String type) {
        this.performerid = performerid;
        this.performername = performername;
        this.type = type;
    }

    public String getPerformerid() {
        return performerid;
    }

    public String getPerformername() {
        return performername;
    }

    public String getType() {
        return type;
    }

    public void setPerformerid(String performerid) {
        this.performerid = performerid;
    }

    public void setPerformername(String performername) {
        this.performername = performername;
    }

    public void setType(String type) {
        this.type = type;
    }
 
}
