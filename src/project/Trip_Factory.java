/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Admin
 */
public class Trip_Factory {
    String Type_of_Trip;
    
    public Trips Get_Trip(String Type_of_Trip){
        if(Type_of_Trip.equals(null)){
            return null;
        }
        if(Type_of_Trip.equalsIgnoreCase("Adventure")){
            return new Adventure();
            
        }
        else if(Type_of_Trip.equalsIgnoreCase("Safari_Holidays")){
            return new Safari_Holidays();
            
        }
        
          else if(Type_of_Trip.equalsIgnoreCase("Cultural")){
            return new Cultural();
            
        }
        else if(Type_of_Trip.equalsIgnoreCase("Religious")){
            return new Religious();
            
        }
        
        
        return null;
        
    }
    
        
    
    
    
}
