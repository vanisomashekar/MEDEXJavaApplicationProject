/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.userinterface.PharmacyRole;

import Buisness.Products.Product;
import Buisness.Products.ProductDirectory;
import Business.CustomerAccount.CustomerAccount;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.SupplierEnterprise;
import Business.Network.Network;
import Business.Order.Order;
import Business.Order.OrderDirectory;
import Business.Organization.Organization;
import Business.Organization.SupplierProcurementOrganization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import userinterface.CartJPanel;
import userinterface.LabRole.LabWorkAreaJPanel;
import userinterface.LabRole.ProductDescJPanel;
import userinterface.OrderPlacement.CustomerAccountJPanel;
import userinterface.OrderPlacement.OrderJPanel;
import userinterface.SuppliesManagerRole.Renderer1;
import userinterface.SuppliesManagerRole.ViewPanel;

/**
 *
 * @author Harshitha
 */
public class PharmacyWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PharmacyWorkAreaJPanel
     */
    private CustomerAccount account;
    private JPanel userProcessContainer;
    private EcoSystem system;
    private Organization organization;
    private Enterprise enterprise;
    public PharmacyWorkAreaJPanel(JPanel userProcessContainer, CustomerAccount account, Organization organization, Enterprise enterprise, EcoSystem system) {
        initComponents();
        this.account =account;
        this.userProcessContainer =userProcessContainer;
        this.system= system;
        this.enterprise = enterprise;
        this.organization=organization;
        refreshTable();
        mostbought();
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
         headerRenderer.setBackground(new Color(85,79,102));

         for (int i = 0; i < analyzerTable2.getModel().getColumnCount(); i++) {
        analyzerTable2.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
         for (int i = 0; i < analyzerTable.getModel().getColumnCount(); i++) {
        analyzerTable.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
         for (int i = 0; i < analyzerTable1.getModel().getColumnCount(); i++) {
        analyzerTable1.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
    }
    
    public void  mostbought(){
        OrderDirectory od = new OrderDirectory();
        ProductDirectory prod = new ProductDirectory();
    Map<Integer,Integer> mostbought =  new HashMap<Integer,Integer>();
    for(CustomerAccount account1 : organization.getCustomerAccountDirectory().getUserAccountList()){
            for(Order o : account1.getOrderDirectory().getOrderList()){
                od.getOrderList().add(o);
            }
        }
    for (Order o : od.getOrderList()){
        for(Product p : o.getProductList()){
            if(p.getProductType().equals("Drug")){
           prod.getAllProducts().add(p);
        }
        }
    }
    for (Product p : prod.getAllProducts()){
        int noofQuantity = p.getQuantity();
        int noofproducts =0;
        for(int i= noofQuantity;i>0;i--){
        if(mostbought.containsKey(p.getID()))
            noofproducts = mostbought.get(p.getID());
        noofproducts+=1;
        noofQuantity = noofQuantity -1;
        mostbought.put(p.getID(),noofproducts);
        }
    }
    Set<Map.Entry<Integer,Integer>> set = mostbought.entrySet();
    List<Map.Entry<Integer,Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(set);
    Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>()
    {
        public int compare(Map.Entry<Integer,Integer> o1,Map.Entry<Integer,Integer> o2){
            return(o2.getValue()).compareTo(o1.getValue());
        }
    });
    int productID = 0 ;
    System.out.println("\n Top most bought products");
    for(int i =0; i< list.size() && i< 1 ;i++){
        System.out.println(list.get(i));
        productID = list.get(i).getKey();
    }
   for(Product p : prod.getAllProducts()){
       if(productID == p.getID()){
           name.setText(p.getName());
           description.setText(p.getDesc());
           BufferedImage imgFromDb = null;
        InputStream in = new ByteArrayInputStream(p.getImagetry());
        try {
             imgFromDb = ImageIO.read(in);
             ImageIcon icon = new ImageIcon(imgFromDb);
//    ImageIcon i = ResizeImage(imgFromDb,null);
        Product1 .setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(ViewPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
   } 
   int productID2 = 0;
   for(int i =0; i< list.size() && i< 2 ;i++){
        System.out.println(list.get(i));
        productID2 = list.get(i).getKey();
    }
   for(Product p : prod.getAllProducts()){
       if(productID2 == p.getID()){
           name1.setText(p.getName());
           description1.setText(p.getDesc());
           BufferedImage imgFromDb = null;
        InputStream in = new ByteArrayInputStream(p.getImagetry());
        try {
             imgFromDb = ImageIO.read(in);
             ImageIcon icon = new ImageIcon(imgFromDb);
//    ImageIcon i = ResizeImage(imgFromDb,null);
        Product2 .setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(ViewPanel.class.getName()).log(Level.SEVERE, null, ex);
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

        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        Panel = new javax.swing.JPanel();
        TabPanel = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        Product1 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        Product2 = new javax.swing.JLabel();
        name1 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        description1 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        sortbyJComboBox = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        analyzerSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        analyzerTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        sortbyJComboBox3 = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        analyzerSearch3 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        analyzerTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        sortbyJComboBox2 = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        analyzerSearch2 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        analyzerTable2 = new javax.swing.JTable();

        setBackground(new java.awt.Color(44, 44, 91));

        jButton9.setBackground(new java.awt.Color(44, 44, 91));
        jButton9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton9.setForeground(new java.awt.Color(171, 238, 255));
        jButton9.setText("HOME ");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(44, 44, 91));
        jButton10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton10.setForeground(new java.awt.Color(171, 238, 255));
        jButton10.setText("ORDERS");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(44, 44, 91));
        jButton11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton11.setForeground(new java.awt.Color(171, 238, 255));
        jButton11.setText("ACCOUNT");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(44, 44, 91));
        jButton8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton8.setForeground(new java.awt.Color(171, 238, 255));
        jButton8.setText("CART");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        Panel.setLayout(new java.awt.CardLayout());

        jPanel6.setBackground(new java.awt.Color(44, 44, 91));

        jPanel9.setBackground(new java.awt.Color(44, 44, 91));

        jButton1.setBackground(new java.awt.Color(44, 44, 91));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(171, 238, 255));
        jButton1.setText("SHOP");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        name.setBackground(new java.awt.Color(44, 44, 91));
        name.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        name.setForeground(new java.awt.Color(171, 238, 255));

        description.setBackground(new java.awt.Color(44, 44, 91));
        description.setColumns(20);
        description.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        description.setForeground(new java.awt.Color(171, 238, 255));
        description.setRows(5);
        jScrollPane7.setViewportView(description);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Product1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane7)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 1118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(62, 62, 62))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(Product1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(36, 98, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(220, 220, 220))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel13.setBackground(new java.awt.Color(44, 44, 91));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(171, 238, 255));
        jLabel13.setText("BEST PRODUCTS ");

        jPanel10.setBackground(new java.awt.Color(44, 44, 91));

        jButton2.setBackground(new java.awt.Color(44, 44, 91));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(171, 238, 255));
        jButton2.setText("SHOP");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        name1.setBackground(new java.awt.Color(44, 44, 91));
        name1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        name1.setForeground(new java.awt.Color(171, 238, 255));

        description1.setBackground(new java.awt.Color(44, 44, 91));
        description1.setColumns(20);
        description1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        description1.setForeground(new java.awt.Color(171, 238, 255));
        description1.setRows(5);
        jScrollPane8.setViewportView(description1);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Product2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(name1, javax.swing.GroupLayout.DEFAULT_SIZE, 1118, Short.MAX_VALUE)
                    .addComponent(jScrollPane8))
                .addGap(193, 193, 193)
                .addComponent(jButton2)
                .addGap(62, 62, 62))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(Product2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(name1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel13)
                .addContainerGap(1716, Short.MAX_VALUE))
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1924, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 759, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        TabPanel.addTab("HOME", jPanel5);

        jPanel2.setBackground(new java.awt.Color(44, 44, 91));
        jPanel2.setForeground(new java.awt.Color(44, 44, 91));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(171, 238, 255));
        jLabel1.setText("SORT BY");

        sortbyJComboBox.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        sortbyJComboBox.setForeground(new java.awt.Color(171, 238, 255));
        sortbyJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECT AN OPTION", "PRICE LOW TO HIGH", "PRICE HIGH TO LOW" }));
        sortbyJComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sortbyJComboBoxMouseClicked(evt);
            }
        });
        sortbyJComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                sortbyJComboBoxItemStateChanged(evt);
            }
        });
        sortbyJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortbyJComboBoxActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(171, 238, 255));
        jLabel7.setText("SEARCH");

        analyzerSearch.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        analyzerSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                analyzerSearchKeyReleased(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(44, 44, 91));
        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        analyzerTable.setBackground(new java.awt.Color(44, 44, 91));
        analyzerTable.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        analyzerTable.setForeground(new java.awt.Color(171, 238, 255));
        analyzerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME", "PRODUCT", "PRICE"
            }
        ));
        analyzerTable.setRowHeight(150);
        analyzerTable.setSelectionBackground(new java.awt.Color(85, 79, 102));
        analyzerTable.setSelectionForeground(new java.awt.Color(171, 238, 255));
        analyzerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                analyzerTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(analyzerTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(sortbyJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(237, 237, 237)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(analyzerSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(sortbyJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(analyzerSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE))
        );

        TabPanel.addTab("PRESCRIPTION DRUGS", jPanel2);

        jPanel3.setBackground(new java.awt.Color(44, 44, 91));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(171, 238, 255));
        jLabel4.setText("SORT BY");

        sortbyJComboBox3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        sortbyJComboBox3.setForeground(new java.awt.Color(171, 238, 255));
        sortbyJComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECT AN OPTION", "PRICE LOW TO HIGH", "PRICE HIGH TO LOW" }));
        sortbyJComboBox3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sortbyJComboBox3MouseClicked(evt);
            }
        });
        sortbyJComboBox3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                sortbyJComboBox3ItemStateChanged(evt);
            }
        });
        sortbyJComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortbyJComboBox3ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(171, 238, 255));
        jLabel10.setText("SEARCH");

        analyzerSearch3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        analyzerSearch3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                analyzerSearch3KeyReleased(evt);
            }
        });

        jScrollPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane2MouseClicked(evt);
            }
        });

        analyzerTable1.setBackground(new java.awt.Color(44, 44, 91));
        analyzerTable1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        analyzerTable1.setForeground(new java.awt.Color(171, 238, 255));
        analyzerTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME", "PRODUCT", "PRICE"
            }
        ));
        analyzerTable1.setRowHeight(150);
        analyzerTable1.setSelectionBackground(new java.awt.Color(85, 79, 102));
        analyzerTable1.setSelectionForeground(new java.awt.Color(171, 238, 255));
        analyzerTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                analyzerTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(analyzerTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(sortbyJComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(237, 237, 237)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(analyzerSearch3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(sortbyJComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(analyzerSearch3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
                .addGap(9, 9, 9))
        );

        TabPanel.addTab("NON-PRESCRIPTION DRUGS", jPanel3);

        jPanel4.setBackground(new java.awt.Color(44, 44, 91));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(171, 238, 255));
        jLabel3.setText("SORT BY");

        sortbyJComboBox2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        sortbyJComboBox2.setForeground(new java.awt.Color(171, 238, 255));
        sortbyJComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECT AN OPTION", "PRICE LOW TO HIGH", "PRICE HIGH TO LOW" }));
        sortbyJComboBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sortbyJComboBox2MouseClicked(evt);
            }
        });
        sortbyJComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                sortbyJComboBox2ItemStateChanged(evt);
            }
        });
        sortbyJComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortbyJComboBox2ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(171, 238, 255));
        jLabel9.setText("SEARCH");

        analyzerSearch2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        analyzerSearch2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                analyzerSearch2KeyReleased(evt);
            }
        });

        jScrollPane3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane3MouseClicked(evt);
            }
        });

        analyzerTable2.setBackground(new java.awt.Color(44, 44, 91));
        analyzerTable2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        analyzerTable2.setForeground(new java.awt.Color(171, 238, 255));
        analyzerTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME", "PRODUCT", "PRICE"
            }
        ));
        analyzerTable2.setRowHeight(150);
        analyzerTable2.setSelectionBackground(new java.awt.Color(85, 79, 102));
        analyzerTable2.setSelectionForeground(new java.awt.Color(171, 238, 255));
        analyzerTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                analyzerTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(analyzerTable2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(sortbyJComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(237, 237, 237)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(analyzerSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1088, Short.MAX_VALUE))
            .addComponent(jScrollPane3)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(sortbyJComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(analyzerSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE))
        );

        TabPanel.addTab("PET MEDS", jPanel4);

        Panel.add(TabPanel, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton9)
                .addGap(30, 30, 30)
                .addComponent(jButton10)
                .addGap(28, 28, 28)
                .addComponent(jButton11)
                .addGap(26, 26, 26)
                .addComponent(jButton8)
                .addGap(45, 45, 45))
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton10, jButton11, jButton8, jButton9});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(jButton9)
                    .addComponent(jButton10)
                    .addComponent(jButton11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton10, jButton11, jButton8, jButton9});

    }// </editor-fold>//GEN-END:initComponents

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        Panel.removeAll();
        Panel.add("TabPanel",TabPanel);
        CardLayout layout =(CardLayout) Panel.getLayout();
        layout.next(Panel);
        Component[] components= userProcessContainer.getComponents();
        for (Component c: components)
        {

            if(c instanceof PharmacyWorkAreaJPanel)

            {
                PharmacyWorkAreaJPanel panel=(PharmacyWorkAreaJPanel)c;
                panel. refreshTable();
            }
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    public void refreshTable(){
        int rowCount = analyzerTable.getRowCount();
                    DefaultTableModel model = (DefaultTableModel)analyzerTable.getModel();
        for(int i = rowCount - 1; i >=0; i--) {
            model.removeRow(i);
        }
        for(Network network:system.getNetworkList()){
            for(Enterprise e:network.getEnterpriseDirectory().getEnterpriseList()){
                if(e instanceof SupplierEnterprise){
                        for(Organization o :e.getOrganizationDirectory().getOrganizationList()){
                        if(o instanceof SupplierProcurementOrganization){
                                for(Product p :o.getProductDirectory().getDrugproductlist()){
                                  if(p.getType().equals("PRESCRIPTION DRUGS") ){
                                        Product pro=p;
                                         double price=p.getPrice();
                                         BufferedImage imgFromDb = null;
                                            InputStream in = new ByteArrayInputStream(p.getImagetry());
                                            try {
                                                imgFromDb = ImageIO.read(in);
                                                ImageIcon icon = new ImageIcon(imgFromDb);
                                                model.addRow(new Object[] {pro,p.getImagetry(),price});
                                                analyzerTable.getColumnModel().getColumn(1).setCellRenderer(new Renderer1());

                                                } catch (IOException ex) {
                                                Logger.getLogger(ViewPanel.class.getName()).log(Level.SEVERE, null, ex);
                                                                         }
                                    }
                                    }
                                }
                            }
                        }
                    }    
                }
            int rowCount5 = analyzerTable1.getRowCount();
            DefaultTableModel model5 = (DefaultTableModel)analyzerTable1.getModel();
        for(int i = rowCount5 - 1; i >=0; i--) {
            model5.removeRow(i);
        }
        for(Network network:system.getNetworkList()){
            for(Enterprise e:network.getEnterpriseDirectory().getEnterpriseList()){
                if(e instanceof SupplierEnterprise){
                        for(Organization o :e.getOrganizationDirectory().getOrganizationList()){
                        if(o instanceof SupplierProcurementOrganization){
                                for(Product p :o.getProductDirectory().getDrugproductlist()){
                                  if(p.getType().equals("NON-PRESCRIPTION DRUGS")){
                                        Product pro=p;
                                         double price=p.getPrice();
                                         BufferedImage imgFromDb = null;
                                            InputStream in = new ByteArrayInputStream(p.getImagetry());
                                            try {
                                                imgFromDb = ImageIO.read(in);
                                                ImageIcon icon = new ImageIcon(imgFromDb);
                                                model5.addRow(new Object[] {pro,p.getImagetry(),price});
                                                analyzerTable1.getColumnModel().getColumn(1).setCellRenderer(new Renderer1());

                                                } catch (IOException ex) {
                                                Logger.getLogger(ViewPanel.class.getName()).log(Level.SEVERE, null, ex);
                                                                         }
                                    }
                                    }
                                }
                            }
                        }
                    }    
                }    
            int rowCount1 = analyzerTable2.getRowCount();
            DefaultTableModel model1 = (DefaultTableModel)analyzerTable2.getModel();
        for(int i = rowCount1 - 1; i >=0; i--) {
            model1.removeRow(i);
        }
        for(Network network:system.getNetworkList()){
            for(Enterprise e:network.getEnterpriseDirectory().getEnterpriseList()){
                if(e instanceof SupplierEnterprise){
                        for(Organization o :e.getOrganizationDirectory().getOrganizationList()){
                        if(o instanceof SupplierProcurementOrganization){
                                for(Product p :o.getProductDirectory().getDrugproductlist()){
                                  if(p.getType().equals("PET MEDS")){
                                       Product pro=p;
                                         double price=p.getPrice();
                                         BufferedImage imgFromDb = null;
                                            InputStream in = new ByteArrayInputStream(p.getImagetry());
                                            try {
                                                imgFromDb = ImageIO.read(in);
                                                ImageIcon icon = new ImageIcon(imgFromDb);
                                                model1.addRow(new Object[] {pro,p.getImagetry(),price});
                                                analyzerTable2.getColumnModel().getColumn(1).setCellRenderer(new Renderer1());

                                                } catch (IOException ex) {
                                                Logger.getLogger(ViewPanel.class.getName()).log(Level.SEVERE, null, ex);
                                                                         }
                                    }
                                }
                            }
                        }
                    }    
                }
    }
    }
    
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        Panel.removeAll();
        OrderJPanel order = new OrderJPanel(Panel,system,account,organization);
        Panel.add(order);
        CardLayout layout =(CardLayout) Panel.getLayout();
        layout.next(Panel);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        Panel.removeAll();
        CustomerAccountJPanel customer = new CustomerAccountJPanel(Panel,system,account,organization);
        Panel.add(customer);
        CardLayout layout =(CardLayout) Panel.getLayout();
        layout.next(Panel);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        Panel.removeAll();
        CartJPanel cart = new CartJPanel(Panel,system,account,organization,enterprise);
        Panel.add("Cart",cart);
        CardLayout crdLyt = (CardLayout) Panel.getLayout();
        crdLyt.next(Panel);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void sortbyJComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sortbyJComboBoxMouseClicked
        if (sortbyJComboBox.getSelectedItem() == "PRICE LOW TO HIGH"){
            TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(analyzerTable.getModel());
            analyzerTable.setRowSorter(sorter);

            List<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>(25);
            sortKeys.add(new RowSorter.SortKey(2, SortOrder.ASCENDING));
            sorter.setSortKeys(sortKeys);
        }
        else if (sortbyJComboBox.getSelectedItem() == "PRICE HIGH TO LOW"){
            TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(analyzerTable.getModel());
            analyzerTable.setRowSorter(sorter);

            List<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>(25);
            sortKeys.add(new RowSorter.SortKey(2, SortOrder.DESCENDING));
            sorter.setSortKeys(sortKeys);
        }
    }//GEN-LAST:event_sortbyJComboBoxMouseClicked

    private void sortbyJComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_sortbyJComboBoxItemStateChanged
        if (sortbyJComboBox.getSelectedItem() == "PRICE LOW TO HIGH"){
            TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(analyzerTable.getModel());
            analyzerTable.setRowSorter(sorter);

            List<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>(25);
            sortKeys.add(new RowSorter.SortKey(2, SortOrder.ASCENDING));
            sorter.setSortKeys(sortKeys);
        }
        else if (sortbyJComboBox.getSelectedItem() == "PRICE HIGH TO LOW"){
            TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(analyzerTable.getModel());
            analyzerTable.setRowSorter(sorter);

            List<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>(25);
            sortKeys.add(new RowSorter.SortKey(2, SortOrder.DESCENDING));
            sorter.setSortKeys(sortKeys);
        }
    }//GEN-LAST:event_sortbyJComboBoxItemStateChanged

    private void sortbyJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortbyJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sortbyJComboBoxActionPerformed

    private void analyzerSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_analyzerSearchKeyReleased
        DefaultTableModel dtm = (DefaultTableModel)analyzerTable.getModel();
        String search = analyzerSearch.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dtm);
        analyzerTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_analyzerSearchKeyReleased

    private void analyzerTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_analyzerTableMouseClicked
        int selectRow= analyzerTable.getSelectedRow();
        Product p=(Product)analyzerTable.getValueAt(selectRow, 0);

        ProductDescJPanel ProductDesc= new ProductDescJPanel(Panel,p,organization,enterprise,account);
        Panel.add("ProductDesc",ProductDesc);
        CardLayout layout=(CardLayout) Panel.getLayout();
        layout.next(Panel);
    }//GEN-LAST:event_analyzerTableMouseClicked

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked

    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void sortbyJComboBox3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sortbyJComboBox3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_sortbyJComboBox3MouseClicked

    private void sortbyJComboBox3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_sortbyJComboBox3ItemStateChanged
       if (sortbyJComboBox3.getSelectedItem() == "PRICE LOW TO HIGH"){
            TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(analyzerTable1.getModel());
            analyzerTable1.setRowSorter(sorter);

            List<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>(25);
            sortKeys.add(new RowSorter.SortKey(2, SortOrder.ASCENDING));
            sorter.setSortKeys(sortKeys);
        }
        else if (sortbyJComboBox3.getSelectedItem() == "PRICE HIGH TO LOW"){
            TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(analyzerTable1.getModel());
            analyzerTable1.setRowSorter(sorter);

            List<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>(25);
            sortKeys.add(new RowSorter.SortKey(2, SortOrder.DESCENDING));
            sorter.setSortKeys(sortKeys);
        }
    }//GEN-LAST:event_sortbyJComboBox3ItemStateChanged

    private void sortbyJComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortbyJComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sortbyJComboBox3ActionPerformed

    private void analyzerSearch3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_analyzerSearch3KeyReleased
        DefaultTableModel dtm = (DefaultTableModel)analyzerTable1.getModel();
        String search = analyzerSearch3.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dtm);
        analyzerTable1.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_analyzerSearch3KeyReleased

    private void analyzerTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_analyzerTable1MouseClicked
        int selectRow= analyzerTable1.getSelectedRow();
        Product p=(Product)analyzerTable1.getValueAt(selectRow, 0);

        ProductDescJPanel ProductDesc= new ProductDescJPanel(Panel,p,organization,enterprise,account);
        Panel.add("ProductDesc",ProductDesc);
        CardLayout layout=(CardLayout) Panel.getLayout();
        layout.next(Panel);
    }//GEN-LAST:event_analyzerTable1MouseClicked

    private void jScrollPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane2MouseClicked

    private void sortbyJComboBox2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sortbyJComboBox2MouseClicked
      if (sortbyJComboBox2.getSelectedItem() == "PRICE LOW TO HIGH"){
            TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(analyzerTable2.getModel());
            analyzerTable2.setRowSorter(sorter);

            List<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>(25);
            sortKeys.add(new RowSorter.SortKey(2, SortOrder.ASCENDING));
            sorter.setSortKeys(sortKeys);
        }
        else if (sortbyJComboBox2.getSelectedItem() == "PRICE HIGH TO LOW"){
            TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(analyzerTable2.getModel());
            analyzerTable2.setRowSorter(sorter);

            List<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>(25);
            sortKeys.add(new RowSorter.SortKey(2, SortOrder.DESCENDING));
            sorter.setSortKeys(sortKeys);
        }
    }//GEN-LAST:event_sortbyJComboBox2MouseClicked

    private void sortbyJComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_sortbyJComboBox2ItemStateChanged
       if (sortbyJComboBox2.getSelectedItem() == "PRICE LOW TO HIGH"){
            TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(analyzerTable2.getModel());
            analyzerTable2.setRowSorter(sorter);

            List<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>(25);
            sortKeys.add(new RowSorter.SortKey(2, SortOrder.ASCENDING));
            sorter.setSortKeys(sortKeys);
        }
        else if (sortbyJComboBox2.getSelectedItem() == "PRICE HIGH TO LOW"){
            TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(analyzerTable2.getModel());
            analyzerTable2.setRowSorter(sorter);

            List<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>(25);
            sortKeys.add(new RowSorter.SortKey(2, SortOrder.DESCENDING));
            sorter.setSortKeys(sortKeys);
        }
    }//GEN-LAST:event_sortbyJComboBox2ItemStateChanged

    private void sortbyJComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortbyJComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sortbyJComboBox2ActionPerformed

    private void analyzerSearch2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_analyzerSearch2KeyReleased
        DefaultTableModel dtm = (DefaultTableModel)analyzerTable2.getModel();
        String search = analyzerSearch2.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dtm);
        analyzerTable2.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_analyzerSearch2KeyReleased

    private void analyzerTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_analyzerTable2MouseClicked
       int selectRow= analyzerTable2.getSelectedRow();
        Product p=(Product)analyzerTable2.getValueAt(selectRow, 0);

        ProductDescJPanel ProductDesc= new ProductDescJPanel(Panel,p,organization,enterprise,account);
        Panel.add("ProductDesc",ProductDesc);
        CardLayout layout=(CardLayout) Panel.getLayout();
        layout.next(Panel);
    }//GEN-LAST:event_analyzerTable2MouseClicked

    private void jScrollPane3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane3MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Product product = null;
        OrderDirectory od = new OrderDirectory();
        ProductDirectory prod = new ProductDirectory();
        for(CustomerAccount account1 : organization.getCustomerAccountDirectory().getUserAccountList()){
            for(Order o : account1.getOrderDirectory().getOrderList()){
                od.getOrderList().add(o);
            }
        }
        for (Order o : od.getOrderList()){
            for(Product p : o.getProductList()){
                prod.getAllProducts().add(p);
            }
        }
        for (Product p : prod.getAllProducts()){
            if  (name.getText().equals(p.getName()));
            product =p;
        }
        ProductDescJPanel ProductDesc= new ProductDescJPanel(Panel,product,organization,enterprise,account);
        Panel.add("ProductDesc",ProductDesc);
        CardLayout layout=(CardLayout) Panel.getLayout();
        layout.next(Panel);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Product product = null;
        OrderDirectory od = new OrderDirectory();
        ProductDirectory prod = new ProductDirectory();
        for(CustomerAccount account1 : organization.getCustomerAccountDirectory().getUserAccountList()){
            for(Order o : account1.getOrderDirectory().getOrderList()){
                od.getOrderList().add(o);
            }
        }
        for (Order o : od.getOrderList()){
            for(Product p : o.getProductList()){
                prod.getAllProducts().add(p);
            }
        }
        for (Product p : prod.getAllProducts()){
            if  (name1.getText().equals(p.getName()));
            product =p;
        }
        ProductDescJPanel ProductDesc= new ProductDescJPanel(Panel,product,organization,enterprise,account);
        Panel.add("ProductDesc",ProductDesc);
        CardLayout layout=(CardLayout) Panel.getLayout();
        layout.next(Panel);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    private javax.swing.JLabel Product1;
    private javax.swing.JLabel Product2;
    private javax.swing.JTabbedPane TabPanel;
    private javax.swing.JTextField analyzerSearch;
    private javax.swing.JTextField analyzerSearch2;
    private javax.swing.JTextField analyzerSearch3;
    private javax.swing.JTable analyzerTable;
    private javax.swing.JTable analyzerTable1;
    private javax.swing.JTable analyzerTable2;
    private javax.swing.JTextArea description;
    private javax.swing.JTextArea description1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel name;
    private javax.swing.JLabel name1;
    private javax.swing.JComboBox sortbyJComboBox;
    private javax.swing.JComboBox sortbyJComboBox2;
    private javax.swing.JComboBox sortbyJComboBox3;
    // End of variables declaration//GEN-END:variables
}
