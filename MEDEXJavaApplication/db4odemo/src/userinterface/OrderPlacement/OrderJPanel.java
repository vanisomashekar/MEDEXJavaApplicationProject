/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.OrderPlacement;

import Buisness.Products.Product;
import Business.CustomerAccount.CustomerAccount;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Order.Order;
import Business.Organization.Organization;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vaniv
 */
public class OrderJPanel extends javax.swing.JPanel {

    /**
     * Creates new form OrderJPanel
     */
    private JPanel container;
    private EcoSystem system;
    private CustomerAccount account;
    private Organization organization;

    public OrderJPanel(JPanel Panel, EcoSystem system, CustomerAccount account, Organization organization) {
       initComponents();
       this.container =Panel;
       this.system =system;
       this.account =account;
       this.organization =organization;
       DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
         headerRenderer.setBackground(new Color(85,79,102));

         for (int i = 0; i < OrderTable.getModel().getColumnCount(); i++) {
        OrderTable.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
       int rowCount = OrderTable.getRowCount();
        DefaultTableModel Table = (DefaultTableModel)OrderTable.getModel();
        for(int i = rowCount - 1; i >=0; i--) {
            Table.removeRow(i);
        }
       for(Order o : account.getOrderDirectory().getOrderList()){
           for(Product p : o.getProductList()){
               Object row[] = new Object[4]; 
                                        row[0]=p;
                                        row[1]=p.getName();
                                        row[2]=p.getQuantity();
                                        row[3]=p.getQuantity()*p.getPrice();
                                        Table.addRow(row);
           }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        OrderTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(44, 44, 91));
        setForeground(new java.awt.Color(171, 238, 255));

        OrderTable.setBackground(new java.awt.Color(44, 44, 91));
        OrderTable.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        OrderTable.setForeground(new java.awt.Color(171, 238, 255));
        OrderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PRODUCT NAME", "PRODUCT", "QUANTITY", "PRICE"
            }
        ));
        jScrollPane1.setViewportView(OrderTable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(171, 238, 255));
        jLabel1.setText("ORDER HISTORY");

        jButton1.setBackground(new java.awt.Color(44, 44, 91));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(171, 238, 255));
        jButton1.setText("REVIEW PRODUCT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(471, 471, 471)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1011, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(869, 869, 869)
                        .addComponent(jLabel1)))
                .addContainerGap(472, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(849, 849, 849))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                .addGap(42, 42, 42)
                .addComponent(jButton1)
                .addGap(43, 43, 43))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      int selectRow= OrderTable.getSelectedRow();
        if(selectRow<0)
        {
            JOptionPane.showMessageDialog(null, "Please select Product to verify");
        }
        else
        {
        Product p =(Product)OrderTable.getValueAt(selectRow, 0);
        
        container.removeAll();
        ReviewJPanel order = new ReviewJPanel(container,system,account,organization,p);
        container.add(order);
        CardLayout layout =(CardLayout) container.getLayout();
        layout.next(container);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable OrderTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
