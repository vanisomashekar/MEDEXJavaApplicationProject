/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.AdOrderManagerRole;

import Buisness.Products.Product;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.BidWorkRequest;
import Business.WorkQueue.OrderWorkRequest;
import Business.WorkQueue.WorkRequest;
import static com.db4o.internal.Platform4.now;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import userinterface.SuppliesManagerRole.Renderer1;

/**
 *
 * @author Harshitha
 */
public class AdminOrderManagerJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AdminOrderManagerJPanel
     */
     private UserAccount account;
    private Enterprise enterprise;
    private Organization organization;
    private JPanel userProcessContainer;
    private EcoSystem buisness;
    public AdminOrderManagerJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise,EcoSystem buisness) {
        initComponents();
        this.account=account;
        this.enterprise=enterprise;
        this.organization=organization;
        this.userProcessContainer=userProcessContainer;
        this.buisness=buisness;
        populateTable();
                
    }
    
    public void populateTable()
    {
        DefaultTableModel model = (DefaultTableModel)BidRequestTable.getModel();
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new Color(85,79,102));

        for (int i = 0; i < BidRequestTable.getModel().getColumnCount(); i++) {
       BidRequestTable.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
       }
        
        model.setRowCount(0);
        
        ArrayList<WorkRequest> al=organization.getWorkQueue().getWorkRequestList();
        
         Collections.sort(al, new Comparator<WorkRequest>()
    {
        public int compare(WorkRequest o1,WorkRequest o2){
            return(o1.getMessage()).compareTo(o2.getMessage());
        }
    }

            );

 
        
        for(WorkRequest request : al){
//            Object[] row = new Object[5];
//            row[0] = request;
            if(!request.getStatus().equals("Approve"))
            {
           String supname= ((BidWorkRequest) request).getSuppliersender();
           Product proname =((BidWorkRequest) request).getPro();
          int prioff=((BidWorkRequest) request).getProPrice();
          // int prioff=((BidWorkRequest) request).getProPrice();
//            //row[3] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
           String status = request.getStatus();
        
            BidRequestTable.setRowHeight(50);
  
            
             model.addRow(new Object[] {request,supname,proname,prioff,status});
              BidRequestTable.getColumnModel().getColumn(4).setCellEditor((new ComboRenderer()));
  //  BidRequestTable.getColumnModel().getColumn(3).setCellEditor(new ComboRenderer());
            
           // model.addRow(row);
              
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
        BidRequestTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(44, 44, 91));

        BidRequestTable.setBackground(new java.awt.Color(44, 44, 91));
        BidRequestTable.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BidRequestTable.setForeground(new java.awt.Color(171, 238, 255));
        BidRequestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "REQUEST", "SUPPLIER NAME", "PRODUCT NAME", "PRICE OFFERED", "STATUS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        BidRequestTable.setSelectionBackground(new java.awt.Color(85, 79, 102));
        BidRequestTable.setSelectionForeground(new java.awt.Color(171, 238, 255));
        BidRequestTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BidRequestTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(BidRequestTable);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(171, 238, 255));
        jLabel1.setText("BIDDING REQUEST FROM SUPPLIERS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(291, 291, 291)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1255, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(728, 728, 728)
                        .addComponent(jLabel1)))
                .addContainerGap(328, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(98, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BidRequestTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BidRequestTableMouseClicked
        // TODO add your handling code here:
        int selectedRow = BidRequestTable.getSelectedRow();

        if (selectedRow < 0){
            return;
        }
        
        Product p=(Product)BidRequestTable.getValueAt(selectedRow, 2);
       
       String s=(String)BidRequestTable.getValueAt(selectedRow, 4);
       WorkRequest request= (BidWorkRequest)BidRequestTable.getValueAt(selectedRow, 0);
      // request.setTestResult("S");
       // request.setTestResult(s);
        request.setStatus(s);
       if(request.getStatus().equals("Approve"))
                {
                     p.setStatus("Bided");
                }
        request.setResolveDate(now());
        
        
        
       // request.
    }//GEN-LAST:event_BidRequestTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BidRequestTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
