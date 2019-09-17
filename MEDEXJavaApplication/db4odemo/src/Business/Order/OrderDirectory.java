/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Order;

import Buisness.Products.Product;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author vaniv
 */
public class OrderDirectory {

    private ArrayList<Order> orderList;

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }

    public OrderDirectory() {
        orderList = new ArrayList();
    }
    
     public Order createOrder(String customerName){
         Order order = new Order(customerName);
          orderList.add(order);
         return order;
     }
     
     public ArrayList<Order> unique(ArrayList<Order> ol)
    {
         ArrayList<Order> result = new ArrayList<Order>();

        HashSet<Order> set = new HashSet<Order>();

        // Loop over argument list.
        for (Order item :ol ) {

            // If String is not in set, add it to the list and the set.
            if (!set.contains(item)) {
                result.add(item);
                set.add(item);
            }
        }
        return result;
    }
    }

