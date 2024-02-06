/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class facade_book {
    Client client;
    Trips trip;
    public facade_book()
    {
        client=new Client();
        trip= new Trips() {
            @Override
            public void getDetails_forClient(String name) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public double income_for_each_category() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        } ;
        
    }
    public boolean Book(String name_trip,String name_client)
    {
        ChooseTrip ct= new ChooseTrip();
        
            if(trip.book(name_trip, name_client)){
           if(client.book(name_trip, name_client))
        {
                trip.updateprofit(name_trip);
                
                return true;
            }
            else
           {System.out.println("money is not enough");
            JOptionPane.showMessageDialog(ct, "money is not enough");}
                
        }
        
        else{JOptionPane.showMessageDialog(ct, "trip is completed");
        System.out.println("trip is completed");}
        return false;
    }
    
    
    
}
