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
import static project.Add_tour.conn;
import static project.Add_tour.query;
import static project.Register.conn;
import static project.sqlconn.statment;



/**
 *
 * @author Admin
 */
public class Adventure extends Trips{
    sqlconn sql= sqlconn.getconnection();
    //Trips t ;
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
    /* try{
            sqlconn con=new sqlconn();
            conn=con.connect();
            System.out.println("connected");
            query="select Tour, price,Date from trip where name='"+selectedName+"'";
            statment=conn.createStatement();
            ResultSet rs= statment.executeQuery(query);
            rs.next();
            System.out.println(rs.getString("Tour"));
            price1.setText(rs.getString("price"));
            tour_guide.setText(rs.getString("Tour"));
            date1.setText(rs.getString("Date"));
            
        } catch (SQLException ex) {
            Logger.getLogger(ChooseTrip.class.getName()).log(Level.SEVERE, null, ex);
        }*/

    @Override
    public double income_for_each_category() {
        //To change body of generated methods, choose Tools | Templates.
        double income=0;
        try
        {
             conn=sql.connect();
            System.out.println("connected");
            String name= "Adventure";
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
