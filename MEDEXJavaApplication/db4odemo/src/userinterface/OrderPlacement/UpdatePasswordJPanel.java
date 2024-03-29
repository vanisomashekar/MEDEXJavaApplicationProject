/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.OrderPlacement;

import Business.Customer.Customer;
import Business.CustomerAccount.CustomerAccount;
import Business.EcoSystem;
import Business.Organization.Organization;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Harshitha
 */
public class UpdatePasswordJPanel extends javax.swing.JPanel {

    /**
     * Creates new form UpdatePasswordJPanel
     */
     private JPanel container;
    private EcoSystem system;
    private CustomerAccount account;
    private Organization organization;
    
    public UpdatePasswordJPanel(JPanel container, EcoSystem system, CustomerAccount account, Organization organization) {
        initComponents();
        this.container =container;
       this.system =system;
       this.account =account;
       this.organization =organization;
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
        txtPword = new javax.swing.JTextField();
        txtRePword = new javax.swing.JTextField();
        pswdLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        usernameTF = new javax.swing.JTextField();

        setBackground(new java.awt.Color(44, 44, 91));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(171, 238, 255));
        jLabel1.setText("UPDATE LOGIN CREDENTIALS");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(171, 238, 255));
        jLabel2.setText("NEW PASSWORD:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(171, 238, 255));
        jLabel3.setText("RE-TYPE NEW PASSWORD:");

        txtPword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPwordKeyReleased(evt);
            }
        });

        txtRePword.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtRePword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRePwordKeyReleased(evt);
            }
        });

        pswdLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pswdLabel.setForeground(new java.awt.Color(255, 51, 0));

        jButton1.setBackground(new java.awt.Color(44, 44, 91));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(171, 238, 255));
        jButton1.setText("UPDATE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(171, 238, 255));
        jLabel4.setText("NEW USERNAME:");

        usernameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(598, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPword, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRePword, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67)
                        .addComponent(pswdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(252, 252, 252))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(1030, 1030, 1030))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(745, 745, 745))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(703, 703, 703))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(usernameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pswdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRePword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(86, 86, 86)
                .addComponent(jButton1)
                .addContainerGap(309, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtPwordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPwordKeyReleased
        if(isValidPassword(txtPword.getText()))
        {
            pswdLabel.setText("");
        }
        else {

            pswdLabel.setText("Invalid Password, should contain min 8 characters include atleast one Uppercase,lowercase and number");
        }
    }//GEN-LAST:event_txtPwordKeyReleased

    private void txtRePwordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRePwordKeyReleased
         if(ismatched())
        {
            txtRePword.setBackground(Color.GREEN);
        }
        else
        {
            txtRePword.setBackground(Color.RED);
        }
    }//GEN-LAST:event_txtRePwordKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String pswd= txtRePword.getText();
        String username1=usernameTF.getText();
        account.setPassword(pswd);
        account.setUsername(username1);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void usernameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTFActionPerformed

public boolean isValidPassword(String password) {
        String PPattern = "^(?=.*[0-9])(?=.*[a-z])(?!.*[*?&@!#^()-])(?!.*[%.])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,12}$";
        //String PPatern="[A-Za-z0-9\\+_\\$]{6,12}";
        java.util.regex.Pattern p1=java.util.regex.Pattern.compile(PPattern);
        java.util.regex.Matcher m1 = p1.matcher(password);
           return m1.matches();
    }
public boolean ismatched() {
   
       if(txtRePword.getText().equals(txtPword.getText()))
       {
          return true;
                   } 
       else
       {
           return false;
       }
     
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel pswdLabel;
    private javax.swing.JTextField txtPword;
    private javax.swing.JTextField txtRePword;
    private javax.swing.JTextField usernameTF;
    // End of variables declaration//GEN-END:variables
}
