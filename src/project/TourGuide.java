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
import static project.Add_tour.conn;

/**
 *
 * @author Admin
 */
public class TourGuide extends Person{
    
    private int age;
    private double salary;
    private String[] Trips;
    //0 for not available,1 is available
    private int isavailable;

    public int getIsavailable() {
        return isavailable;
    }

    public void setIsavailable(int isavailable) {
        this.isavailable = isavailable;
    }
    static Connection conn;
    static Statement statment;
    static String query;
    sqlconn con=sqlconn.getconnection();
public String[] getTour_available()
{
    String[] name=new String[5];
    int index=0;
     try
         {
            conn=con.connect();
            System.out.println("connected");
            query="select name from tourguide where isavailable=1";
            statment=conn.createStatement();
            ResultSet rs= statment.executeQuery(query);
            while(rs.next())
            {   
                name[index]=rs.getString("name");
                index++;
                
            }
            return name;
         }
         catch(SQLException ex)
         {
             System.out.println(ex.getMessage());
         }
        
    return name;
}
   
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String[] getTrips() {
        return Trips;
    }

    public void setTrips(String[] Trips) {
        this.Trips = Trips;
    }
    
    
    
}
