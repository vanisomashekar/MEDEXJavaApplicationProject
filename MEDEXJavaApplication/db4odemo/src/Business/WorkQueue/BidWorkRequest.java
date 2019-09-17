/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Buisness.Products.Product;
import Business.Order.Order;
import Business.UserAccount.UserAccount;
import java.util.Comparator;

/**
 *
 * @author Harshitha
 */
    
    public class BidWorkRequest extends WorkRequest{
      private String testResult;
      private Product pro;
      private String Suppliersender;
      private Order order;
      private int proPrice;

    public int getProPrice() {
        return proPrice;
    }

    public void setProPrice(int proPrice) {
        this.proPrice = proPrice;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getSuppliersender() {
        return Suppliersender;
    }

    public void setSuppliersender(String Suppliersender) {
        this.Suppliersender = Suppliersender;
    }

    public Product getPro() {
        return pro;
    }

    public void setPro(Product pro) {
        this.pro = pro;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }
    
    
            class Sortbyroll implements Comparator<BidWorkRequest> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(BidWorkRequest a, BidWorkRequest b) 
    { 
        return  a.proPrice- b.proPrice; 
    } 
    
            }
    
    }
    

