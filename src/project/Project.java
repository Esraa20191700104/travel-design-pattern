/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class Project {

    /**
     * @param args the command line arguments
     */
    static String user="root"; 
    public static void main(String[] args) throws SQLException {
        
        // TODO code application logic here
       
       Home r= new Home();
        r.show();
        
        
    }
    
}
