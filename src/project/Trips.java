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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static project.CancelRegistration.conn;
import static project.Cancel_trip.conn;
import static project.Client.query;
import static project.Client.statment;
import static project.Edit_tour.conn;
import static project.Edit_tour.statment;

/**
 *
 * @author Admin
 */
public abstract class Trips implements Book_Trip{
   private String Date;
    private String guidetour;
    private String Trip_name;
    private int Number_of_tourists ;
    private int count_of_tourists=0;
    private int price;
    private double  total_profit;
    private int id;
    private String categoryName;
    private String Sites;

    public String getSites() {
        return Sites;
    }

    public void setSites(String Sites) {
        this.Sites = Sites;
    }
    
    

    
    

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        this.Date = date;
    }

    public String getGuidetour() {
        return guidetour;
    }

    public void setGuidetour(String guidetour) {
        this.guidetour = guidetour;
    }

    public String getTrip_name() {
        return Trip_name;
    }

    public void setTrip_name(String Trip_name) {
        this.Trip_name = Trip_name;
    }

    public int getNumber_of_tourists() {
        return Number_of_tourists;
    }

    public void setNumber_of_tourists(int Number_of_tourists) {
        this.Number_of_tourists = Number_of_tourists;
    }

    public int getCount_of_tourists() {
        return count_of_tourists;
    }

    public void setCount_of_tourists(int count_of_tourists) {
        this.count_of_tourists = count_of_tourists;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getTotal_profit() {
        return total_profit;
    }

    public void setTotal_profit(double total_profit) {
        this.total_profit = total_profit;
    }
    public abstract void getDetails_forClient(String name);
    public abstract double income_for_each_category();
static Connection conn;
    static Statement statment;
    static String query;
    sqlconn con=sqlconn.getconnection();
    @Override
    public  boolean book(String name_trip,String name_client){
        try{
            conn=con.connect();
            query="select NumberOftourist,totalNumber from trip where name='"+name_trip+"'";
             statment= conn.createStatement();
             ResultSet rs= statment.executeQuery(query);
             rs.next();
             if(rs.getInt("totalNumber")==rs.getInt("NumberOftourist"))
                 return false;
             else
             {
                 int newnumber=rs.getInt("totalNumber")+1;
                 String sql="update trip set totalNumber='"+newnumber+"' where name='"+name_trip+"'";
                 statment= conn.createStatement();
                  statment.execute(sql);
                  return true;
                 
             }
             
        } catch (SQLException ex) {
           Logger.getLogger(Trips.class.getName()).log(Level.SEVERE, null, ex);
       }
        return false;
    }
    public void updateprofit(String trip)
    {
        try{
            conn=con.connect();
            query="select price,totalNumber from trip where name='"+trip+"'";
             statment= conn.createStatement();
             ResultSet rs= statment.executeQuery(query);
             rs.next();
                 int newprofit=rs.getInt("totalNumber")*rs.getInt("price");
                 String sql="update trip set totalProfit='"+newprofit+"' where name='"+trip+"'";
                 statment= conn.createStatement();
                  statment.execute(sql);
                  
             
             
        } catch (SQLException ex) {
           Logger.getLogger(Trips.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    public void insert_inClient_Trip(Trips t,String nameofclient)
    {
        try{
            conn=con.connect();
            String sql="insert into clienttrip values('"+nameofclient+"'"+Date+ "','"+Trip_name+"')";
            statment= conn.createStatement();
            statment.execute(sql);
            System.out.println("client trip is added");
            
        } catch (SQLException ex) {
           Logger.getLogger(Trips.class.getName()).log(Level.SEVERE, null, ex);
       }
    }   
    public void change_trip(String name_trip,int id)
    {
        try{
   conn=con.connect();
   query="select totalNumber,price from trip where name='"+name_trip+"'";
   statment=conn.createStatement();
    ResultSet rs=statment.executeQuery(query);
    rs.next();
    int new_totalnumber=rs.getInt("totalNumber")-1;
    double new_profit=rs.getInt("price")* new_totalnumber;
    String sql="update trip set totalNumber='"+new_totalnumber+"',totalProfit='"+new_profit+"'"
            + " where name='"+name_trip+"'";
   statment= conn.createStatement();
   statment.execute(sql);
   query="select money,Name from client where ID='"+id+"'";
   statment=conn.createStatement();
    ResultSet rs2=statment.executeQuery(query);
    rs2.next();
    String nameclient=rs2.getString("Name");
    int new_money=rs2.getInt("money")+rs.getInt("price");
    sql="update client set money='"+new_money+"' where Name='"+nameclient+"'";
   statment= conn.createStatement();
   statment.execute(sql);
    
            
   
    }      catch (SQLException ex) {   
            Logger.getLogger(CancelRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    public int[] getcommingTrio_for_employee()
    {
        
    int[] id= new int[5];
        try
         {
           
            conn=con.connect();
           System.out.println("connected");
             DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyy-MM-dd");
            LocalDate Now=LocalDate.now();
             System.out.println(dtf.format(Now));
             
             
            query="select * from trip";
            statment=conn.createStatement();
            ResultSet rs= statment.executeQuery(query);
            int index=0;
            while(rs.next())
            {   
                
            
                java.sql.Date date=rs.getDate("Date");
                System.out.println(date);
                if (Now.isBefore(date.toLocalDate())) {
                    //jComboBox1.addItem(rs.getString("ID"));
                    id[index]=rs.getInt("ID");
                    index++;
                    
                 System.out.println("Now is after Date2");
    }
            }
            return id;
         } catch (SQLException ex) {
           Logger.getLogger(Trips.class.getName()).log(Level.SEVERE, null, ex);
       }
    
    return id;
            
    }
    public int[] get_id_oftrip()
    {
        int[] id=new int[6];
         try
         {
            sqlconn con=sqlconn.getconnection();
            int index=0;
            conn=con.connect();
            System.out.println("connected");
            query="select ID from trip";
            statment=conn.createStatement();
            ResultSet rs= statment.executeQuery(query);
            while(rs.next())
            {   
               id[index]=rs.getInt("ID");
               index++;
            }
            return id;
         }
         catch(SQLException ex)
         {
             System.out.println(ex.getMessage());
         }
         return id;
    }
    
    
    
    
}
