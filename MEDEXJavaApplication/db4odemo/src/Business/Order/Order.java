/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Order;

import Buisness.Products.Product;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author vaniv
 */
public class Order {

   
    private int OrderID;


    @Override
    public String toString() {
        return "OrderID=" + OrderID ;
    }
    private int customerID;
    private String customerName;
    private ArrayList<Product> productList;
    private String orderStatus;

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }
   private static int count = 1;
    
    public Order(String customerName) {
        productList = new ArrayList();
        OrderID = count;
        setCustomerID(customerName);
        count++;
    }
    

    public Product createProduct(String name,int ID,String desc,double price,int quantity,String type,String supplierName,String productType,byte[] image,String status){
        Product p = new Product(name,ID,desc,price,quantity,type,supplierName,productType,status);
        p.setImagetry(image);
        productList.add(p);
        return p;
    }

    public void setCustomerID(String CustomerName){
        this.customerName=CustomerName;
    }
    
    public String getCustomerID() {
        return customerName;
    }
   
}
