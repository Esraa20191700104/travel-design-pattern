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
public class Proxy_Login implements interface_login{
   private interface_login rl=new Real_Login();
   sqlconn sql=sqlconn.getconnection();
   int [] idclient=sql.getclientid();
   int [] passclient=sql.getclientpass();
   int[] idemployee=sql.getemployeeid();
   int[] passemployee=sql.getemployeepass();
   Login log=new  Login();
    @Override
    public boolean signup(int id,int password) {
        for(int i=0;i<idclient.length;i++)
        {
            if(id==idclient[i]&password==passclient[i])
            { 
               rl.signup(id, password);
               return true;   
            }
        }
         //rl.signup(id, password);
        JOptionPane.showMessageDialog(log, "wrong password or id ");
       return false;
        
    }

    @Override
    public boolean signinEmployee(int id, int password) {
        for(int i=0;i<idemployee.length;i++)
        {
            if(id==idemployee[i]&password==passemployee[i])
            { 
               rl.signinEmployee(id, password);
               return true;   
            }
        }
         //rl.signup(id, password);
        JOptionPane.showMessageDialog(log, "wrong password or id ");
       return false;
       
    }
    
}
