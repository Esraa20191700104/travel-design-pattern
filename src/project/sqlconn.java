/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Struct;
import static project.ChooseTrip.statment;
import static project.Login.conn;

/**
 *
 * @author Admin
 */

public class sqlconn {
    
    private String user="root";
    
    private  String paasword="";
    
    static Statement statment;
    static String query;
    //instance is connection
    private static sqlconn connection=null;
    private sqlconn(){
        
    }

    public static sqlconn getconnection() {
        if(connection==null)
        {
            connection=new sqlconn();
        }
        return connection;
    }
    private  String add="jdbc:mysql://localhost:3306/travel?zeroDateTimeBehavior=convertToNull";
    
    public Connection connect() throws SQLException{
        Connection r= DriverManager.getConnection(add, user, paasword);
            System.out.println("connected");
        return r;
    }
    public int[] getclientid(){
        int[] id=new int[50];
         try{
             sqlconn con=new sqlconn();
            conn=con.connect();
            
            System.out.println("connected");
            PreparedStatement ps= conn.prepareStatement("select * from client ");
            ResultSet rs= ps.executeQuery();
            int index=0;
            while(rs.next()){
                id[index]=rs.getInt("ID");
                index++;
                
            }
         
         
         
         }
         catch(SQLException ex)
         {
             System.out.println(ex.getMessage());
         }
        return id;
    }
     public int[] getemployeeid(){
        int[] id=new int[50];
         try{
             sqlconn con=new sqlconn();
            conn=con.connect();
            
            System.out.println("connected");
            PreparedStatement ps= conn.prepareStatement("select * from employee ");
            ResultSet rs= ps.executeQuery();
            int index=0;
            while(rs.next()){
                id[index]=rs.getInt("ID");
                index++;
                
            }
         
         
         
         }
         catch(SQLException ex)
         {
             System.out.println(ex.getMessage());
         }
        return id;
    }
      public int[] getclientpass(){
        int[] pass=new int[50];
         try{
             sqlconn con=new sqlconn();
            conn=con.connect();
            
            System.out.println("connected");
            PreparedStatement ps= conn.prepareStatement("select * from client ");
            ResultSet rs= ps.executeQuery();
            int index=0;
            while(rs.next()){
                pass[index]=rs.getInt("password");
                index++;
                
            }
         
         
         
         }
         catch(SQLException ex)
         {
             System.out.println(ex.getMessage());
         }
        return pass;
    }
    public int[] getemployeepass(){
        int[] pass=new int[50];
         try{
             sqlconn con=new sqlconn();
            conn=con.connect();
            
            System.out.println("connected");
            PreparedStatement ps= conn.prepareStatement("select * from employee ");
            ResultSet rs= ps.executeQuery();
            int index=0;
            while(rs.next()){
                pass[index]=rs.getInt("password");
                index++;
                
            }
         
         
         
         }
         catch(SQLException ex)
         {
             System.out.println(ex.getMessage());
         }
        return pass;
    }
    public ResultSet get_detailsoftrip(String name) throws SQLException
    {
         
        try{
            sqlconn con=new sqlconn();
            conn=con.connect();
            System.out.println("connected");
            query="select Tour, price,Date,Sites from trip where name='"+name+"'";
            statment=conn.createStatement();
            ResultSet rs= statment.executeQuery(query);
            rs.next();
            System.out.println(rs.getString("Tour"));
            return rs;
            
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return null;
        
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
    
    
}
