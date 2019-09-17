/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SupOrderManagerRole;

import Business.CustomerAccount.CustomerAccount;
import Business.Enterprise.Enterprise;
import Business.Order.Order;
import Business.EcoSystem;
import Buisness.Products.Product;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.SupplierSalesOrganization;
import Business.Organization.SupplierProcurementOrganization;
import Business.Organization.CustomerServiceOrganization;
import Business.Organization.TpManagementOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.OrderWorkRequest;
import Business.WorkQueue.TpWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Renderer;
import userinterface.SupOrderManagerRole.BiddingSystem;
import javax.swing.table.DefaultTableModel;
import Business.Enterprise.SupplierEnterprise;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import userinterface.AdOrderManagerRole.ProcessOrderJPanel;
import userinterface.AdminRole.JavaApplication14;

/**
 *
 * @author Harshitha
 */
public class SupOrderManagerWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SupOrderManagerWorkAreaJPanel
     */
    
        private UserAccount account;
    private Enterprise enterprise1;
    private Organization organization;
    private EcoSystem business;
    private JPanel userProcessContainer;
    
    public SupOrderManagerWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise,EcoSystem buisness) {
        initComponents();
        this.account=account;
        this.enterprise1=enterprise;
        this.organization=organization;
        this.userProcessContainer=userProcessContainer;
        this.business=buisness;
        sname.setText(enterprise.getName());
        populateTable();
        
    }
    
     public void populateTable(){
        DefaultTableModel model = (DefaultTableModel)ordersTable.getModel();
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new Color(85,79,102));

        for (int i = 0; i < ordersTable.getModel().getColumnCount(); i++) {
       ordersTable.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
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
//        if (org!=null){
//    
//                   for (CustomerAccount ca: org.getCustomerAccountDirectory().getUserAccountList())
//                   {
//                       System.out.println("order is"+ ca.getOrderDirectory().getOrderList());
//                       ArrayList<Order> or=ca.getOrderDirectory().unique(ca.getOrderDirectory().getOrderList());
//                       System.out.println("uniq" + or.toString());
//                       for (Order o:or){
//                           for (Product p:o.getProductList())
//                           {
//                           
//                               String name=p.getName();
//                               for (Product po :org1.getProductDirectory().getAllProducts())
//                               {
//                    if (name.equals(po.getName()))
//                    {
//                            
////                     Object[] row = new Object[3];
////                        row[0] = o.getOrderID();
////                        row[1] = p.getName();
////                        row[2]=p.getQuantity();
////                         model.addRow(row);
//                        
//                    }
//                               }
//                           }
//                       }
//                           
//           
//                }
//        } 
        DefaultTableModel model1 = (DefaultTableModel)ordersTable.getModel();
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
                                                   for (Product prod1: o1.getProductDirectory().getAllProducts())
                                                   {
                                                       if (prod1.getName().equals(p.getName()))
                                                       {
                                                           //for (Product prod: o.getProductDirectory().getAllProducts())
                                                   {
                                                          ArrayList<String> vani= new ArrayList<String>();
                                                          for (Product pls : o.getProductDirectory().getAllProducts())
                                                          {
                                                              vani.add(pls.getName());
                                                          }
                                                                  
                                                          
                                                          
                                                          System.out.println("gghk"+ vani);
                                                          if(!vani.contains(p.getName()))
                                                          {
                                                      if (!p.getStatus().equals("Completed"))
                                                       { 
                                                            Object[] row = new Object[4];
                                                         row[0] = p;
                                                         row[1] = order1;
                                                         row[2]=p.getQuantity();
                                                        // row[3]=order1.getOrderID();
                                                         model1.addRow(row);
                                                       }
                                                       }
                                                   }
                                                        
                                                    }
                                               }
                                                   
                                               }
                                                 
                                             }
//                                        }
//                                        
//                                    }

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
        ordersTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        messageJTextField = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        sname = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(44, 44, 91));

        ordersTable.setBackground(new java.awt.Color(44, 44, 91));
        ordersTable.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ordersTable.setForeground(new java.awt.Color(171, 238, 255));
        ordersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ORDERPRODUCTNAME", "ORDER", "QUANTITY"
            }
        ));
        ordersTable.setRowHeight(150);
        ordersTable.setSelectionBackground(new java.awt.Color(85, 79, 102));
        ordersTable.setSelectionForeground(new java.awt.Color(171, 238, 255));
        jScrollPane1.setViewportView(ordersTable);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(171, 238, 255));
        jLabel1.setText("ORDERS LIST");

        jButton1.setBackground(new java.awt.Color(85, 79, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(171, 238, 255));
        jButton1.setText("BID FOR PRODUCT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(85, 79, 102));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(171, 238, 255));
        jButton2.setText("SEND TO THIRDPARTY");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        messageJTextField.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jButton3.setBackground(new java.awt.Color(85, 79, 102));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(171, 238, 255));
        jButton3.setText("CHECK STATUS");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(171, 238, 255));
        jLabel2.setText("SUPPLIER NAME :");

        sname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sname.setForeground(new java.awt.Color(171, 238, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(171, 238, 255));
        jLabel3.setText("ADD MESSAGE :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 386, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(sname, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(136, 136, 136)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(392, 392, 392))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(messageJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1060, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(390, 390, 390))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sname, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(messageJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(152, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void assignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButtonActionPerformed

//        int selectedRow = workRequestJTable.getSelectedRow();
//
//        if (selectedRow < 0){
//            return;
//        }
//
//        WorkRequest request = (WorkRequest)workRequestJTable.getValueAt(selectedRow, 0);
//        request.setReceiver(account);
//        request.setStatus("Pending");
//        populateTable();

    }//GEN-LAST:event_assignJButtonActionPerformed

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed

        
//        int selectedRow = workRequestJTable.getSelectedRow();
//
//        if (selectedRow < 0){
//            return;
//        }
//
//        OrderWorkRequest request = (OrderWorkRequest)workRequestJTable.getValueAt(selectedRow, 0);
//
//        request.setStatus("Processing");
//        
//
//        ProcessWorkRequestJPanel processWorkRequestJPanel = new ProcessWorkRequestJPanel(userProcessContainer, request);
//        userProcessContainer.add("processWorkRequestJPanel", processWorkRequestJPanel);
//        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
//        layout.next(userProcessContainer);
        
        

    }//GEN-LAST:event_processJButtonActionPerformed

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        populateTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        BiddingSystem bs= new BiddingSystem(userProcessContainer,account,organization,enterprise1,business);
        userProcessContainer.add("ProductDesc",bs);
        CardLayout layout=(CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
       
            

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int selectedRow = ordersTable.getSelectedRow();
        if (selectedRow < 0){
            
            JOptionPane.showMessageDialog(null, "Please select a row from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(messageJTextField.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please enter a message to the ThirdParty");
        }
        else
        {
  
         Order o=(Order)ordersTable.getValueAt(selectedRow, 1);
           
        String message = messageJTextField.getText();
        
      TpWorkRequest request = new TpWorkRequest();
        request.setMessage(message);
        request.setSender(account);
        request.setStatus("SentFromSupplier");
        request.setOrder(o);
         System.out.println("order is"+ request.getOrder());
         Product ptry=((Product)ordersTable.getValueAt(selectedRow, 0));
         ptry.setStatus("Completed");
         request.setProduct(ptry.getName());
        //request.setProduct(pna);
            System.out.println(request.getProduct());
        
     Organization org = null;
        for(Network network:business.getNetworkList()){
            for(Enterprise enterprise:network.getEnterpriseDirectory().getEnterpriseList()){
                for(Organization organization1:enterprise.getOrganizationDirectory().getOrganizationList()){
                    //for (Organization.Type type : Organization.Type.values()){
      // for(Organization organization1 : buisness.getAod().getAllOrganizations()){
       // for (Organization organization1 : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization1 instanceof TpManagementOrganization){
                org = organization1;
                break;
            }
        }
            }
        }
        if (org!=null){
            org.getWorkQueue().getWorkRequestList().add(request);
            account.getWorkQueue().getWorkRequestList().add(request);
        }
        JOptionPane.showMessageDialog(null, "Order has been sent to the thirdParty");
        sendmail(o);
        
        }
    }//GEN-LAST:event_jButton2ActionPerformed
public void sendmail(Order ord)
     {
         Organization org=null;
         for(Network network:business.getNetworkList()){
            for(Enterprise enterprise:network.getEnterpriseDirectory().getEnterpriseList()){
                for(Organization organization1:enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization1 instanceof CustomerServiceOrganization){
                org = organization1;
                break;
            }
        }
            }

                 for (CustomerAccount ca :org.getCustomerAccountDirectory().getUserAccountList())
                         {  
                           for (Order o :ca.getOrderDirectory().getOrderList())
                           {
                               if(o.getCustomerID()== ord.getCustomerID())
                               {
                             String mail=ca.getCustomer().getEmail();
                             JavaApplication14 em=new JavaApplication14(mail,"Supplier");
                             
                         }
             }
                         }
         }
     }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        checkStatusJPanel viewPanel= new checkStatusJPanel(userProcessContainer,account,organization,enterprise1,business);
            userProcessContainer.add("ViewPanel",viewPanel);
            CardLayout layout=(CardLayout)userProcessContainer.getLayout();
            layout.next(userProcessContainer);
    }//GEN-LAST:event_jButton3ActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField messageJTextField;
    private javax.swing.JTable ordersTable;
    private javax.swing.JLabel sname;
    // End of variables declaration//GEN-END:variables
}

