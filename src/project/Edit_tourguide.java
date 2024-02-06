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
import java.util.logging.Level;
import java.util.logging.Logger;
import static project.Edit_account.conn;
import static project.Edit_tour.conn;
import static project.Edit_tour.statment;

/**
 *
 * @author Admin
 */
public class Edit_tourguide extends javax.swing.JFrame {

    /**
     * Creates new form Edit_tourguide
     */
    sqlconn con=sqlconn.getconnection();
     static Connection conn;
    static Statement statment;
    static String query;
    public Edit_tourguide() {
        initComponents();
        try
         {
            
            conn=con.connect();
            System.out.println("connected");
            query="select ID from tourguide";
            statment=conn.createStatement();
            ResultSet rs= statment.executeQuery(query);
            while(rs.next())
            {   
                jComboBox1.addItem(rs.getString("ID"));  
            }
         }
         catch(SQLException ex)
         {
             System.out.println(ex.getMessage());
         }
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        salaryguide = new javax.swing.JTextField();
        ageguide = new javax.swing.JTextField();
        emailguide = new javax.swing.JTextField();
        isguide = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setText("ID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 76, 120, 38));

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel2.setText("Salary");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 120, 108, 42));

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel3.setText("Age");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 176, 123, 37));

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel4.setText("Email");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 220, 125, 39));

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel5.setText("Password");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 268, 94, 46));

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel6.setText("IS_available");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 320, 114, 38));
        getContentPane().add(salaryguide, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 123, 204, 42));
        getContentPane().add(ageguide, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 176, 204, 32));
        getContentPane().add(emailguide, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 223, 204, 39));
        getContentPane().add(isguide, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 324, 204, 37));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Sylfaen", 3, 24)); // NOI18N
        jButton1.setText("UPDATE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 408, 140, 45));

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 73, 204, 41));
        getContentPane().add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 268, 204, 41));

        jLabel7.setFont(new java.awt.Font("Sylfaen", 3, 24)); // NOI18N
        jLabel7.setText("Edit Tour Guide");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 11, 200, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\back4.jpeg")); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, -4, 410, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(evt.getSource()==jButton1)
        {
            try{
            
            conn=con.connect();
            System.out.println("connected");
            String ID= jComboBox1.getSelectedItem().toString();
            String Email= emailguide.getText();
            String salary=salaryguide.getText();
            String password=new String(jPasswordField1.getPassword());
            String age= ageguide.getText();
            String is_avail=isguide.getText();
            String sql="update tourguide set password='"+password+"',email='"+Email+"',"
                    + "isavailable='"+is_avail+"',salary='"+salary+"',"
                    + "Age='"+age+"' where ID='"+ID+"'";
             statment= conn.createStatement();
             statment.execute(sql);
            // String sql="update trip set Date='"+date+"',
            //NumberOftourist='"+number_tourist+"',price='"+price+"' where ID='"+id+"'";
             //statment= conn.createStatement();
            System.out.println("tour guide is updated");
            Menu_client mc=new Menu_client();
            dispose();
            mc.show();
            } 
            
            
            catch (SQLException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                try{
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        try
         {
            
            conn=con.connect();
            System.out.println("connected");
           String id= jComboBox1.getSelectedItem().toString();
            query="select password ,email,isavailable,salary,Age from tourguide where ID='"+id+"'";
            statment=conn.createStatement();
            ResultSet rs= statment.executeQuery(query);
            rs.next();
            salaryguide.setText(rs.getString("salary"));
            isguide.setText(rs.getString("isavailable"));
            ageguide.setText(rs.getString("Age"));
            jPasswordField1.setText(rs.getString("password"));
            emailguide.setText(rs.getString("email"));
         }
         catch(SQLException ex)
         {
             System.out.println(ex.getMessage());
         }
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(Edit_tourguide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Edit_tourguide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Edit_tourguide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Edit_tourguide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Edit_tourguide().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ageguide;
    private javax.swing.JTextField emailguide;
    private javax.swing.JTextField isguide;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField salaryguide;
    // End of variables declaration//GEN-END:variables
}