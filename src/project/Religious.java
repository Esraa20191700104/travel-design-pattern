/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import static project.Add_tour.query;
import static project.Cultural.conn;



/**
 *
 * @author Admin
 */
public class Religious extends Trips{
    sqlconn sql=sqlconn.getconnection();
    static Connection conn;
    static Statement statment;

    @Override
    public void getDetails_forClient(String name) {
        try {
            ResultSet detail=sql.get_detailsoftrip(name);
            //detail.next();
            String tour= detail.getString("Tour");
            System.out.println(detail.getString("Date"));
           setDate(detail.getString("Date"));
            setSites(detail.getString("Sites"));
           setGuidetour(tour);
            setPrice(Integer.parseInt(detail.getString("price")));
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Adventure.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public double income_for_each_category() {
        //To change body of generated methods, choose Tools | Templates.
        double income=0;
        try
        {
            conn=sql.connect();
            String name= "Religious";
            query="select totalProfit from trip where gategory='"+name+"'";
            statment=conn.createStatement();
            ResultSet rs= statment.executeQuery(query);
            while(rs.next())
            {
                income=income+Double.parseDouble(rs.getString("totalProfit"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Adventure.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return income;
    }
    }
    


  
    

