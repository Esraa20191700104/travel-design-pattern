/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class data {
   private static String user ="root";
   private static String password ="";
   private static String uri="jdbc:mysql://localhost/library system";
  
static Connection c;
    static Statement ss;
    static String query, trip1, trip2, trip3, trip4;
    static String query1, client1, client2, client3, client4, client5, client6;
    static String query4,tourguide1,tourguide2,tourguide3,tourguide4;
   
   public void redata()
   {
    data c1 = new data();
        try {
            c = c1.connect();
            ss = (Statement) c.createStatement();

            //book table
            query = "create table trip(id int not null,date DATETIME ,"
                    + "category varchar(30) not null, Tripname varchar(30) not null,"
                    + "TourGuide varchar(30) not null,NumberOftourist int not null,"
                    + "totalNumberofTourist int not null,price int not null,"
                    + "totalprofit int not null ,constraint pk1 primary key(id)   )";
            trip1 = "insert into trip values(1,2022/10/1,'Adventure','trip1','ahmed',20,15,100,500)";
            trip2 = "insert into trip values(2,2022/10/1,'Cultural','trip2','mourad',22,20,100,500)";
            trip3 = "insert into trip values(3,2022/10/1,'Cultural','trip3','mohammed',22,20,100,500)";
            trip4 = "insert into trip values(4,2022/10/1,'Religious','trip4','salim',32,30,200,600)";
            
            
           /* ss.execute(query);
            ss.execute(book1);
            ss.execute(book2);
            ss.execute(book3);
            ss.execute(book4);
            ss.execute(book5);
            ss.execute(book6);
            ss.execute(book7);
            ss.execute(book8);
            ss.execute(book9);
            ss.execute(book10);
            */
             
            //user table
            query1 = "create table client(ID int not null,password varchar(15) not null  ,Name varchar(15) not null,"
                    + "CellPhone int not null,Email varchar(30) not null,constraint pk1 primary key(ID))";

            client1= "insert into user values(1,'123esraa','esraa',0125141651,'esraa@gmail.com')";
            client2 = "insert into user values(2,'123doaa','doaa',011512352,'doaa@gmail.com')";
            client3= "insert into user values(3,'123reham','reham',0125141651,'reham@gmail.com')";
            client4= "insert into user values(4,'123wejdan','wejdan',0125141651,'wejdan@gmail.com')";
            client5= "insert into user values(5,'123rana','rana',0125141651,'rana@gmail.com')";
            client6= "insert into user values(6,'123mahmoud','mahmoud',0125141651,'mahmoud@gmail.com')";
            
            
            query4 = "create table tourguide(ID int not null,password varchar(15) not null  ,Name varchar(15) not null,"
                    + "Email varchar(30) not null, isavailable varchar(20) not null,constraint pk1 primary key(ID))";
            tourguide1= "insert into user values(1,'123ahmed','ahmed','ahmed@gmail.com','yes')";
            tourguide2 = "insert into user values(2,'123mourad','mourad','mourad@gmail.com','no')";
            tourguide3= "insert into user values(3,'123mohammed','mohammed','mohammed@gmail.com','no')";
            tourguide4= "insert into user values(4,'123salim','salim','salim@gmail.com'yes')";

    /*
            ss.execute(query1);
            ss.execute(user1);
            ss.execute(user2);
            ss.execute(user3);
            ss.execute(user4);
            ss.execute(user5);
            ss.execute(user6);
 
*/
            //System.out.println("Saved");
        } catch (SQLException ee) {

            System.out.println(ee.getMessage());
        } finally {
            try {
                c.close();
                //ss.close();
            } catch (SQLException ee) {
                System.out.println(ee.getMessage());
            }
   
   }
   
   
   }
   
   
     public Connection connect() throws SQLException
     {
        return DriverManager.getConnection(uri,user,password);
         
     }
}