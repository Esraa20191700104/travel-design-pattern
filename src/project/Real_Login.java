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
public class Real_Login implements interface_login{
    private int ID;
    private int password;
    Login log=new Login();

    
   

    @Override
    public boolean signup(int id, int password) {
                log.dispose();
                Menu_client mc= new Menu_client();
                mc.show();
         return true;
    }

    @Override
    public boolean signinEmployee(int id, int password) {
        //To change body of generated methods, choose Tools | Templates.
                log.dispose();
                Menu_employee mc= new Menu_employee();
                mc.show();
         return true;
    }
    
    
}
