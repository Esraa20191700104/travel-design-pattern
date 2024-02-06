/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import static project.Login.conn;
import static project.Register.statment;

/**
 *
 * @author Admin
 */
public class ChooseTrip extends javax.swing.JFrame {

    /**
     * Creates new form ChooseTrip
     */
    public ChooseTrip() {
        initComponents();
        
    }
static Connection conn;
    static Statement statment;
    static String query;
     sqlconn con=sqlconn.getconnection();
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nameclient = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        price1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tour_guide = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        date1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("jCheckBoxMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sylfaen", 3, 18)); // NOI18N
        jLabel1.setText("Category of Trips");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 123, 157, 45));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Adventure", "Cultural", "Religious", "Safari_Holidays" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 123, 102, 45));

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 179, 102, 44));

        jButton2.setText("Show Details");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 179, -1, 44));

        jLabel2.setFont(new java.awt.Font("Sylfaen", 3, 18)); // NOI18N
        jLabel2.setText("Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 186, 68, 30));

        jLabel6.setFont(new java.awt.Font("Sylfaen", 3, 18)); // NOI18N
        jLabel6.setText("Name");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 78, 85, -1));
        getContentPane().add(nameclient, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 75, 155, 30));

        jLabel8.setFont(new java.awt.Font("Sylfaen", 3, 36)); // NOI18N
        jLabel8.setText("Book Trip");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 16, 187, -1));

        jLabel9.setFont(new java.awt.Font("Sylfaen", 3, 18)); // NOI18N
        jLabel9.setText("Trip Details");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 126, 38));
        getContentPane().add(price1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 166, 26));

        jLabel3.setFont(new java.awt.Font("Sylfaen", 3, 18)); // NOI18N
        jLabel3.setText("Price");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 105, 21));

        jLabel4.setFont(new java.awt.Font("Sylfaen", 3, 18)); // NOI18N
        jLabel4.setText("Tour Guide");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 105, -1));
        getContentPane().add(tour_guide, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 340, 166, 27));

        jLabel5.setFont(new java.awt.Font("Sylfaen", 3, 18)); // NOI18N
        jLabel5.setText("Date");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 105, 25));
        getContentPane().add(date1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, 166, 25));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 420, -1, 59));

        jLabel7.setFont(new java.awt.Font("Sylfaen", 3, 18)); // NOI18N
        jLabel7.setText("Site");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 89, 31));

        jButton1.setFont(new java.awt.Font("Sylfaen", 3, 18)); // NOI18N
        jButton1.setText("Book");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 520, 190, 39));

        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\back4.jpeg")); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -6, 450, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
       
       
        
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        try {
            // TODO add your handling code here:

            fillcombo();
        } catch (SQLException ex) {
            Logger.getLogger(ChooseTrip.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String selectedName= jComboBox2.getSelectedItem().toString();
        System.out.println(selectedName);
        String selectedvalue=jComboBox1.getSelectedItem().toString();
        Trip_Factory  tf= new Trip_Factory();
        Trips t=tf.Get_Trip(selectedvalue);
        t.getDetails_forClient(selectedName);
        String pr=String.valueOf(t.getPrice());
        price1.setText(pr);
        tour_guide.setText(t.getGuidetour());
        date1.setText(t.getDate());
        jTextArea1.setText(t.getSites());
       /* try{
            sqlconn con=new sqlconn();
            conn=con.connect();
            System.out.println("connected");
            query="select Tour, price,Date from trip where name='"+selectedName+"'";
            statment=conn.createStatement();
            ResultSet rs= statment.executeQuery(query);
            rs.next();
            System.out.println(rs.getString("Tour"));
            price1.setText(rs.getString("price"));
            tour_guide.setText(rs.getString("Tour"));
            date1.setText(rs.getString("Date"));
            
        } catch (SQLException ex) {
            Logger.getLogger(ChooseTrip.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        facade_book book=new facade_book();
        boolean b=book.Book(jComboBox2.getSelectedItem().toString(),nameclient.getText());
        Trip_Factory  tf= new Trip_Factory();
        Trips t=tf.Get_Trip(jComboBox1.getSelectedItem().toString());
        t.setDate(date1.getText());
        t.setTrip_name(jComboBox2.getSelectedItem().toString());
        //t.insert_inClient_Trip(t,nameclient.getText());
        if(b)
        {
            dispose();
            Menu_client mc= new Menu_client();
            mc.show();
        }
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    public void fillcombo() throws SQLException
    {
        String selectedvalue=jComboBox1.getSelectedItem().toString();
        
        
        try{
            
           
            conn=con.connect();
            System.out.println("connected");
            query="select name from trip where gategory='"+selectedvalue+"'";
            //PreparedStatement ps= conn.prepareStatement(query);
            statment=conn.createStatement();
            ResultSet rs= statment.executeQuery(query);
            while(rs.next()){
                
                jComboBox2.addItem(rs.getString("name"));
                
            }
            
            
           
        System.out.println(selectedvalue);} 
        catch (SQLException ex) {
            Logger.getLogger(ChooseTrip.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try{
                conn.close();
                statment.close();
            }
            catch (SQLException ex)
            {
                System.out.println(ex.getMessage());
            }
            
        }
    }
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
            java.util.logging.Logger.getLogger(ChooseTrip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChooseTrip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChooseTrip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChooseTrip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChooseTrip().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField date1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField nameclient;
    private javax.swing.JTextField price1;
    private javax.swing.JTextField tour_guide;
    // End of variables declaration//GEN-END:variables
}