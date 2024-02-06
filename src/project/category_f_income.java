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
public class category_f_income {
    Adventure adven;
    Cultural cul;
    Religious reli;
    Safari_Holidays sh;
    public category_f_income(){
        adven=new Adventure();
        reli=new Religious();
        cul=new Cultural();
        sh=new Safari_Holidays();
    }
    double income=0;
    public double adventureincome()
    {
       income= adven.income_for_each_category();
       return income;
    }
    public double cultureincome()
    {
       income= cul.income_for_each_category();
       return income;
    }
    public double religionincome()
    {
       income= reli.income_for_each_category();
       return income;
    }
    public double safariincome()
    {
       income= sh.income_for_each_category();
       return income;
    }
    
}
