/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import static project.Add_tour.conn;
import static project.Add_tour.statment;
import static project.Cancel_trip.conn;
import static project.DeleteTourguide.conn;
import static project.Edit_tour.conn;

/**
 *
 * @author Admin
 */
public class Employee extends Person{
    
   static Connection conn;
    static Statement statment;
    static String query;
    sqlconn con=sqlconn.getconnection();
    
    public void Add_trip(Trips t) throws SQLException
    {
        try{
            conn=con.connect();
            System.out.println("connected");
            String sql="insert into trip values('"+t.getId()+ "','"+t.getDate()+"',"
                    + "'"+t.getCategoryName()+"','"+t.getTrip_name()+"','"+t.getGuidetour()+"',"
                    + "'"+t.getNumber_of_tourists()+"','"+t.getCount_of_tourists()+"'"
                    + ",'"+t.getPrice()+"','"+t.getTotal_profit()+"','"+t.getSites()+"')";
             statment= conn.createStatement();
             statment.execute(sql);
            query="UPDATE `tourguide` SET `isavailable`=0 where name='"+t.getGuidetour()+"'";
            statment= conn.createStatement();
            statment.execute(query);
            System.out.println("tour is added");
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    public void cancelTrip(Trips t)
    {
        try
         {
            
            conn=con.connect();
           System.out.println("connected");
           
           query="DELETE FROM `trip` WHERE ID='"+t.getId()+"'";
           statment=conn.createStatement();
           statment.execute(query);
         } catch (SQLException ex) {
             Logger.getLogger(Cancel_trip.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    public void editTrip(Trips t){
        
        
            try{
            
            conn=con.connect();
            System.out.println("connected");
            
            String sql="update trip set Date='"+t.getDate()+"',NumberOftourist='"+t.getNumber_of_tourists()+"'"
                    + ",price='"+t.getPrice()+"' where ID='"+t.getId()+"'";
             statment= conn.createStatement();
             statment.execute(sql);
            
            System.out.println("trip is updated");
            
            } 
            
            
            catch (SQLException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                try{
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
                }
            }}
    public void deleteTourGuide(int id)
    {
        try
         {
           
            conn=con.connect();
           System.out.println("connected");
           
           query="DELETE FROM `tourguide` WHERE ID='"+id+"'";
           statment=conn.createStatement();
           statment.execute(query);
         } catch (SQLException ex) {
             Logger.getLogger(Cancel_trip.class.getName()).log(Level.SEVERE, null, ex);
         }
         
    }
    
}
