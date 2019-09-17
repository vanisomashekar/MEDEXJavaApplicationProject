/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.TPOrderManagerRole;

import Buisness.Products.Product;
import Business.CustomerAccount.CustomerAccount;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Order.Order;
import Business.Organization.CustomerServiceOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.BidWorkRequest;
import Business.WorkQueue.TpWorkRequest;
import Business.WorkQueue.WorkRequest;
import static com.db4o.internal.Platform4.now;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import userinterface.AdOrderManagerRole.ComboRenderer;
import userinterface.AdminRole.JavaApplication14;

/**
 *
 * @author Harshitha
 */
public class TPOrderManagerWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form TPOrderManagerWorkAreaJPanel
     */
     private UserAccount account;
    private Enterprise enterprise;
    private Organization organization;
    private EcoSystem business;
    private JPanel userProcessContainer;
    public TPOrderManagerWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise,EcoSystem business) {
        initComponents();
         this.account=account;
        this.enterprise=enterprise;
        this.organization=organization;
        this.userProcessContainer=userProcessContainer;
        this.business=business;
        TPNAME.setText(enterprise.getName());
        populateTable();
 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TPNAME = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(44, 44, 91));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        workRequestJTable.setBackground(new java.awt.Color(44, 44, 91));
        workRequestJTable.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        workRequestJTable.setForeground(new java.awt.Color(171, 238, 255));
        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PRODUCT NAME", "MESSAGE", "STATUS", "SENDER"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        workRequestJTable.setRowHeight(150);
        workRequestJTable.setSelectionBackground(new java.awt.Color(85, 79, 102));
        workRequestJTable.setSelectionForeground(new java.awt.Color(171, 238, 255));
        workRequestJTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                workRequestJTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 209, 946, 308));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(171, 238, 255));
        jLabel1.setText("REQUESTS TO PROCESS ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(836, 110, 319, 44));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(171, 238, 255));
        jLabel2.setText("THIRDPARTY :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 77, 176, -1));

        TPNAME.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TPNAME.setForeground(new java.awt.Color(171, 238, 255));
        jPanel1.add(TPNAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(649, 66, 187, 33));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1873, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
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
                               if(o.getCustomerID()==ord.getCustomerID())
                               {
                             String mail=ca.getCustomer().getEmail();
                             JavaApplication14 em=new JavaApplication14(mail,"ThirdParty");
                             
                         }
             }
                         }
         }
     }
//         }
//         }
//         }
//     }
         
    public void populateTable()
    {
        DefaultTableModel model = (DefaultTableModel)workRequestJTable.getModel();
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new Color(85,79,102));

        for (int i = 0; i < workRequestJTable.getModel().getColumnCount(); i++) {
       workRequestJTable.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
       }
        
        model.setRowCount(0);
//      organization.getWorkQueue().getWorkRequestList().clear();
        
        
        for(WorkRequest request : organization.getWorkQueue().getWorkRequestList()){
            
            if(!request.getStatus().equals("Approved and shipped"))
            {
           // Object[] row = new Object[4];
                
           String pname= ((TpWorkRequest) request).getProduct();
            String sender = request.getSender().getEmployee().getName();
            //row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
            String status = request.getStatus();
            
            
          //  model.addRow(row);
            
          workRequestJTable.setRowHeight(50);
          System.out.println("p naem "+pname);          
            model.addRow(new Object[] {pname,request,status,sender});
              workRequestJTable.getColumnModel().getColumn(2).setCellEditor((new ComboRenderer()));
            }
    }
    }    
    private void workRequestJTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_workRequestJTableMouseClicked
        // TODO add your handling code here:
         int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0){
            return;
        }
       String s=(String)workRequestJTable.getValueAt(selectedRow, 2);
     //  WorkRequest request= (BidWorkRequest)workRequestJTable.getValueAt(selectedRow, 0);
       WorkRequest request = (TpWorkRequest)workRequestJTable.getValueAt(selectedRow, 1);
      // request.setTestResult("S");
       // request.setTestResult(s);
       if(s.equals("Approve"))
       {
        request.setStatus("Approved and shipped");
       }
        if(request.getStatus().equals("Approved and shipped"))
        {
            Order ord=((TpWorkRequest) request).getOrder();
            sendmail(ord);
            request.setSender(account);
            request.setResolveDate(now());
            request.setMessage(String.valueOf(ord.getOrderID()));
             String p=workRequestJTable.getValueAt(selectedRow, 0).toString();
            // p.setProStatus("Completed");
            //ord.setOrderStatus("Complted");
        }
        
    }//GEN-LAST:event_workRequestJTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TPNAME;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
