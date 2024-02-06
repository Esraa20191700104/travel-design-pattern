/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import static project.Add_tour.statment;
import static project.CancelRegistration.conn;
import static project.Edit_account.statment;
import static project.Make_complain.conn;
import static project.Register.statment;
import static project.Trips.statment;
import static project.View_CommingTrip.conn;
import static project.view_complain.conn;

/**
 *
 * @author Admin
 */
public class Client implements Book_Trip{
    private int id;
    private String Name;
    private int pasword;
    private int Age;
    private String []  previous_trips;
    private String curent_tríp;
    private String [] comming_trips;
    private int money;
    private String email;
    private int phone;
    private String complain;

    public String getComplain() {
        return complain;
    }

    public void setComplain(String complain) {
        this.complain = complain;
    }

    

    public int getPasword() {
        return pasword;
    }

    public void setPasword(int pasword) {
        this.pasword = pasword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
    
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getAge() {
        return Age;
    }
    static Connection conn;
    static Statement statment;
    static String query;
    sqlconn con=sqlconn.getconnection();

    public void setAge(int Age) {
        this.Age = Age;
    }

    public String[] getPrevious_trips() {
        return previous_trips;
    }

    public void setPrevious_trips(String[] previous_trips) {
        this.previous_trips = previous_trips;
    }

    public String getCurent_tríp() {
        return curent_tríp;
    }

    public void setCurent_tríp(String curent_tríp) {
        this.curent_tríp = curent_tríp;
    }

    public String[] getComming_trips() {
        return comming_trips;
    }

    public void setComming_trips(String[] comming_trips) {
        this.comming_trips = comming_trips;
    }
    public void register(Client c)
    {
        try{
           conn=con.connect();
           String sql="insert into client values('"+id+ "','"+Name+"',"
                   + "'"+pasword+"','"+email+"',"
                   + "'"+phone+"','"+money+"')";
            statment= conn.createStatement();
            statment.execute(sql);
            System.out.println("user is added");
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    public void Edit_account(Client c)
    {
        try{
           conn=con.connect();
           String sql="update client set Name='"+Name+"',password='"+pasword+"',email='"+email+"',phone='"+phone+"' where ID='"+id+"'";
             statment= conn.createStatement();
             statment.execute(sql);
            
            System.out.println("user is updated");
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    public int get_money_of_client(String name) throws SQLException
    {
        try{
            conn=con.connect();
            query="select money from client where name='"+name+"'";
             statment= conn.createStatement();
             ResultSet rs= statment.executeQuery(query);
             rs.next();
             int money=rs.getInt("money");
             System.out.println(money);
             return money;
            
        }
         catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     return 0;   
    }
public void Make_complain(Client c)
{
    try{
            
            conn=con.connect();
            System.out.println("connected");
            
            String sql="insert into complains values('"+complain+ "')";
             statment= conn.createStatement();
             statment.execute(sql);
            System.out.println("thank you");
            
            
        }   catch (SQLException ex) {
                Logger.getLogger(Make_complain.class.getName()).log(Level.SEVERE, null, ex);
            }
}
    @Override
    public boolean book(String name_trip,String name_client) {
         //To change body of generated methods, choose Tools | Templates.
         try{
             conn=con.connect();
             query="select price from trip where name='"+name_trip+"'";
             statment= conn.createStatement();
             
             ResultSet rs= statment.executeQuery(query);
             rs.next();
             int price= rs.getInt("price");
             System.out.println(price);
             int money=get_money_of_client(name_client);
             if(money>=price)
             {
                 int newmoney=money-price;
                 System.out.println(newmoney);
                 String sql="update client set money='"+newmoney+"' where Name='"+name_client+"'";
                 statment= conn.createStatement();
                  statment.execute(sql);
                  return true;
             }
                          
         } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
         return false;
    }
    public String[] clientTrip(Client c)
    {
        String[] name_trip=new String[5];
        try{
            conn=con.connect();
            query="select Name from client where ID='"+id+"'";
            statment=conn.createStatement();
            ResultSet rs=statment.executeQuery(query);
            rs.next();
            String name=rs.getString("Name");
            System.out.println(name);
            DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyy-MM-dd");
            LocalDate Now=LocalDate.now();
            query="select NameTrip,Date from clienttrip where NameClient='"+name+"'";
            statment=conn.createStatement();
            ResultSet rs2=statment.executeQuery(query);
            int index=0;
            while(rs2.next())
            {
                Date date=rs2.getDate("Date");
                
                if (Now.isBefore(date.toLocalDate())) {
                  
                  name_trip[index]=rs2.getString("NameTrip");
                  index++;
            }
                else if (Now.isEqual(date.toLocalDate()))
                {
                    name_trip[index]=rs2.getString("NameTrip");
                  index++;
                }
                System.out.println("trip is previous");
            }
            return name_trip;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CancelRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    return name_trip;
    
    
    
}
public void cancel(String name_trip)
{
    try{
            conn=con.connect();
           
            query="DELETE FROM `clienttrip` WHERE NameTrip='"+name_trip+"'";
            statment=conn.createStatement();
            statment.execute(query);
            
        } catch (SQLException ex) {
            Logger.getLogger(CancelRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }
}
public Object getcommingTrip(Client c)
{
    try{
            conn=con.connect();
            query="select Date ,NameTrip from clienttrip where NameClient='"+Name+"'";
            statment=conn.createStatement();
            ResultSet rs=statment.executeQuery(query);
             DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyy-MM-dd");
            LocalDate Now=LocalDate.now();
            //DefaultTableModel table1=(DefaultTableModel) jTable1.getModel();
        
        Object[][] complain=new Object[2][5];
        int index=0;
            while(rs.next())
            {
                Date date=rs.getDate("Date");
                
                if (Now.isBefore(date.toLocalDate())) {
                   complain[0][index]=date;
                   complain[1][index]=rs.getString("NameTrip");
                   index++;
                   //table1.addRow(complain);
            }
            
            }
            return complain;
        }
        catch (SQLException ex) {
            Logger.getLogger(ViewpreviousTrip.class.getName()).log(Level.SEVERE, null, ex);
        }
    return complain;
}
public Object[][] clientDetails()
{
    Object[][] client=new Object[5][8];

    try{
            conn=con.connect();
            System.out.println("connected");
            PreparedStatement ps= conn.prepareStatement("select * from client ");
            ResultSet rs= ps.executeQuery();
            //DefaultTableModel table1=(DefaultTableModel) jTable1.getModel();
        
        
        int index=0;
        while(rs.next())
        {
            client[0][index]=rs.getString("ID");
            client[1][index]=rs.getString("Name");
            client[2][index]=rs.getString("password");
            client[3][index]=rs.getString("Phone");
            client[4][index]=rs.getString("email");
           //table1.addRow(client);
           index++;
            
        }
        return client;
}       catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    return client;


}}
