/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SupOrderManagerRole;

import Buisness.Products.Product;
import Business.CustomerAccount.CustomerAccount;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.SupplierEnterprise;
import Business.Network.Network;
import Business.Order.Order;
import Business.Organization.CustomerProcurementOrganization;
import Business.Organization.CustomerServiceOrganization;
import Business.Organization.Organization;
import Business.Organization.SupplierProcurementOrganization;
import Business.Organization.TpManagementOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.BidWorkRequest;
import Business.WorkQueue.TpWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Harshitha
 */
public class BiddingSystem extends javax.swing.JPanel {

    /**
     * Creates new form BiddingSystem
     */
     private UserAccount account;
    private Enterprise enterprise1;
    private Organization organization;
    private EcoSystem business;
    private JPanel userProcessContainer;
    
    public BiddingSystem(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise,EcoSystem buisness) {
        initComponents();
        this.account=account;
        this.enterprise1=enterprise;
        this.organization=organization;
        this.userProcessContainer=userProcessContainer;
        this.business=buisness;
        populateTable();
    }
    public void populateTable()
    {
        
         DefaultTableModel model = (DefaultTableModel)biddingTable.getModel();
         DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new Color(85,79,102));

        for (int i = 0; i < biddingTable.getModel().getColumnCount(); i++) {
       biddingTable.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
       }
        
        model.setRowCount(0);

        Organization org = null;
        Organization org1 = null;
        Organization org2 = null;
        for(Network network:business.getNetworkList()){
            for(Enterprise enterprise:network.getEnterpriseDirectory().getEnterpriseList()){
             
                    if(enterprise.getName().equals(enterprise1.getName())){
                for(Organization organization1:enterprise.getOrganizationDirectory().getOrganizationList()){
                    if(organization1 instanceof SupplierProcurementOrganization){
                org1=organization1;
                    System.out.println("org1"+ org1.getProductDirectory().getAllProducts());
                    break;
            }
                }
                }
                    else
                    {
                         for(Organization organization1:enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization1 instanceof CustomerServiceOrganization){
                org = organization1;
                System.out.println("org"+ org.getCustomerDirectoy().getCustomerList());
                break;
            }
                         }
                    }
        
            }
        }
        if (org!=null){
    
                   for (CustomerAccount ca: org.getCustomerAccountDirectory().getUserAccountList())
                   {
                       System.out.println("order is"+ ca.getOrderDirectory().getOrderList());
                       ArrayList<Order> or=ca.getOrderDirectory().unique(ca.getOrderDirectory().getOrderList());
                       System.out.println("uniq" + or.toString());
                       for (Order o:or){
                           for (Product p:o.getProductList())
                           {
                           
                               String name=p.getName();
                               for (Product po :org1.getProductDirectory().getAllProducts())
                               {
                    if (name.equals(po.getName()))
                    {
                            
//                     Object[] row = new Object[3];
//                        row[0] = o.getOrderID();
//                        row[1] = p.getName();
//                        row[2]=p.getQuantity();
//                         model.addRow(row);
                        
                    }
                               }
                           }
                       }
                           
           
                }
        } 
        
       
    DefaultTableModel model1 = (DefaultTableModel)biddingTable.getModel();
        for(Network n :business.getNetworkList()){
            for(Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()){
                if(e instanceof SupplierEnterprise){
//                for(Enterprise e1 : n.getEnterpriseDirectory().getEnterpriseList()){
//                    if(e1 instanceof SupplierEnterprise){
                      if(e.getName() != enterprise1.getName()){
                          for(Organization o : e.getOrganizationDirectory().getOrganizationList()){
//                              for(Organization o2: enterprise1.getOrganizationDirectory().getOrganizationList()){
                                    if (o instanceof SupplierProcurementOrganization){
                                        for (Organization o1 : enterprise1.getOrganizationDirectory().getOrganizationList()){
                                             if (o1 instanceof SupplierProcurementOrganization){
                                                 for(CustomerAccount c :org.getCustomerAccountDirectory().getUserAccountList()){
                                            for(Order order1:c.getOrderDirectory().getOrderList()){
                                               for(Product p : order1.getProductList()){
                                                   System.out.println("cvhbjk"+ o.getProductDirectory().getAllProducts());
                                                   for (Product prod: o.getProductDirectory().getAllProducts())
                                                   {
                                                       if (prod.getName().equals(p.getName()))
                                                       {
                                                           for (Product prod1: o1.getProductDirectory().getAllProducts())
                                                   {
                                                       if (prod1.getName().equals(p.getName()))
                                                       { 
                                                           if (!p.getStatus().equals("Bided"))
                                                       { 
                                                            Object[] row = new Object[3];
                                                         row[0] = p;
                                                         row[1] = order1;
                                                         row[2]=p.getQuantity();
                                                         //row[3]=
                                                         
                                                         model1.addRow(row);
                                                       }
                                                       }
                                                       }
                                                   }
                                                        
                                                    }
                                               }
                                                   
                                               }
                                                 
                                             }
                                        }
                                        
                                    }

                                                    }
                                                }
                                            }
                                        }
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
        biddingTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        proname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        proprice = new javax.swing.JTextField();
        totalprice = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        actprice = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        msg = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(44, 44, 91));

        biddingTable.setBackground(new java.awt.Color(44, 44, 91));
        biddingTable.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        biddingTable.setForeground(new java.awt.Color(171, 238, 255));
        biddingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PRODUCT", "ORDERID", "QUANTITY REQUIRED"
            }
        ));
        biddingTable.setRowHeight(150);
        biddingTable.setSelectionBackground(new java.awt.Color(85, 79, 102));
        biddingTable.setSelectionForeground(new java.awt.Color(171, 238, 255));
        biddingTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                biddingTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(biddingTable);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(171, 238, 255));
        jLabel1.setText("BIDDING ORDERS");

        jButton1.setBackground(new java.awt.Color(44, 44, 91));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(171, 238, 255));
        jButton1.setText("APPLY TENDER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(171, 238, 255));
        jLabel2.setText("PRODUCT NAME");

        proname.setEditable(false);
        proname.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(171, 238, 255));
        jLabel4.setText("PRICE PER PRODUCT");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(171, 238, 255));
        jLabel5.setText("TOTAL PRICE OFFERED");

        proprice.setEditable(false);
        proprice.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        totalprice.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(171, 238, 255));
        jLabel6.setText("ACTUAL PRICE");

        actprice.setEditable(false);
        actprice.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jButton2.setBackground(new java.awt.Color(44, 44, 91));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(171, 238, 255));
        jButton2.setText("CHECK STATUS");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(171, 238, 255));
        jLabel3.setText("ADD MESSAGE");

        msg.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jButton3.setBackground(new java.awt.Color(44, 44, 91));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(171, 238, 255));
        jButton3.setText("<<BACK");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(316, 316, 316)
                        .addComponent(jLabel5))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(245, 245, 245)
                            .addComponent(jButton2))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(319, 319, 319)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(69, 69, 69)
                                            .addComponent(proname, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(205, 205, 205)
                                            .addComponent(totalprice, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3))
                                    .addGap(33, 33, 33)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(proprice, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(195, 195, 195)
                                            .addComponent(jLabel6)
                                            .addGap(42, 42, 42)
                                            .addComponent(actprice, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(msg, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(44, 44, 44)
                                    .addComponent(jButton3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(369, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {actprice, proname, proprice, totalprice});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(totalprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(msg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 57, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(proprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(actprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(proname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addGap(87, 87, 87))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {actprice, msg, proname, proprice, totalprice});

    }// </editor-fold>//GEN-END:initComponents

    private void biddingTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_biddingTableMouseClicked
        // TODO add your handling code here:
        int selectedRow = biddingTable.getSelectedRow();

        if (selectedRow < 0){
            return;
        }

        Product p = (Product)biddingTable.getValueAt(selectedRow, 0);
        proname.setText(p.getName());
        
        proprice.setText(String.valueOf(p.getPrice()));
        
        actprice.setText(String.valueOf(p.getPrice() * p.getQuantity()));
        
        
        
    }//GEN-LAST:event_biddingTableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int selectedRow = biddingTable.getSelectedRow();

        if (selectedRow < 0){
            return;
        }
         Product p=(Product)biddingTable.getValueAt(selectedRow, 0);
        String message = msg.getText();
       
        Order o=(Order)biddingTable.getValueAt(selectedRow, 1);
      BidWorkRequest request = new BidWorkRequest();
        request.setMessage(message);
        request.setSuppliersender(enterprise1.getName());
        request.setStatus("Sent");
       request.setProPrice(Integer.parseInt(totalprice.getText()));
        request.setPro(p);
        request.setOrder(o);
        
     Organization org = null;
        for(Network network:business.getNetworkList()){
            for(Enterprise enterprise:network.getEnterpriseDirectory().getEnterpriseList()){
                for(Organization organization1:enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization1 instanceof CustomerProcurementOrganization){
                org = organization1;
                break;
            }
        }
            }
        }
        if (org!=null){
            org.getWorkQueue().getWorkRequestList().add(request);
            account.getWorkQueue().getWorkRequestList().add(request);
             JOptionPane.showMessageDialog(null, "Tinder has been sent to the Admin");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         checkBiddingStatus viewPanel= new checkBiddingStatus(userProcessContainer,account,organization,enterprise1,business);
            userProcessContainer.add("ViewPanel",viewPanel);
            CardLayout layout=(CardLayout)userProcessContainer.getLayout();
            layout.next(userProcessContainer);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:\
         userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        SupOrderManagerWorkAreaJPanel dwjp = (SupOrderManagerWorkAreaJPanel) component;
        dwjp.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField actprice;
    private javax.swing.JTable biddingTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField msg;
    private javax.swing.JTextField proname;
    private javax.swing.JTextField proprice;
    private javax.swing.JTextField totalprice;
    // End of variables declaration//GEN-END:variables
}
