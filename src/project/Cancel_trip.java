/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import static project.Edit_account.statment;
import static project.Edit_tour.conn;

/**
 *
 * @author Admin
 */
public class Cancel_trip extends javax.swing.JFrame {

    /**
     * Creates new form Cancel_trip
     */
    
     static Connection conn;
    static Statement statment;
    static String query;
    sqlconn con=sqlconn.getconnection();
    public Cancel_trip() {
        initComponents();
        Trips t= new Trips() {
            @Override
            public void getDetails_forClient(String name) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public double income_for_each_category() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        int[] id=t.getcommingTrio_for_employee();
        for(int i=0;i<id.length;i++)
        {
            jComboBox1.addItem(String.valueOf(id[i]));
        }
                
       /*try
         {
           
            conn=con.connect();
           System.out.println("connected");
             DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyy-MM-dd");
            LocalDate Now=LocalDate.now();
             System.out.println(dtf.format(Now));
             
             
            query="select * from trip";
            statment=conn.createStatement();
            ResultSet rs= statment.executeQuery(query);
            
            while(rs.next())
            {   
                Date date=rs.getDate("Date");
                System.out.println(date);
                if (Now.isBefore(date.toLocalDate())) {
                    jComboBox1.addItem(rs.getString("ID")); 
    System.out.println("Now is after Date2");
}


               // System.out.println(dtf.format(Now)-date);
                 
            }
         }
         catch(SQLException ex)
         {
             System.out.println(ex.getMessage());
         }*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sylfaen", 3, 36)); // NOI18N
        jLabel1.setText("ID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 125, 62));

        jComboBox1.setFont(new java.awt.Font("Sylfaen", 1, 24)); // NOI18N
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 176, 62));

        jButton1.setFont(new java.awt.Font("Sylfaen", 3, 24)); // NOI18N
        jButton1.setText("CANCEL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 232, 162, 40));

        jButton2.setFont(new java.awt.Font("Sylfaen", 3, 24)); // NOI18N
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 378, 115, 39));

        jLabel3.setFont(new java.awt.Font("Sylfaen", 3, 36)); // NOI18N
        jLabel3.setText("Cancel Trip");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 19, 234, 54));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\back4.jpeg")); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, -6, 400, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(evt.getSource()==jButton1)
        {
            
            Trip_Factory  tf= new Trip_Factory();
            try{
                query="select gategory from trip where ID='"+jComboBox1.getSelectedItem().toString()+"'";
                statment=conn.createStatement();
            ResultSet rs= statment.executeQuery(query);
            rs.next();
            
            Trips t=tf.Get_Trip(rs.getString("gategory"));
            t.setId(Integer.valueOf(jComboBox1.getSelectedItem().toString()));
            Employee emp= new Employee();
            emp.cancelTrip(t);
            } catch (SQLException ex) {
                Logger.getLogger(Cancel_trip.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        /* try
         {
            conn=con.connect();
           System.out.println("connected");
           String id=jComboBox1.getSelectedItem().toString();
           query="DELETE FROM `trip` WHERE ID='"+id+"'";
           statment=conn.createStatement();
           statment.execute(query);
         } catch (SQLException ex) {
             Logger.getLogger(Cancel_trip.class.getName()).log(Level.SEVERE, null, ex);
         }*/
         
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
        Menu_employee me= new Menu_employee();
        me.show();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cancel_trip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cancel_trip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cancel_trip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cancel_trip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cancel_trip().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
