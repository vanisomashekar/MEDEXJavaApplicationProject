/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author vaniv
 */
public class CustomerDirectory {
    private ArrayList<Customer> customerList;

    public CustomerDirectory() {
        customerList = new ArrayList();
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }
    
     public Customer createCustomer(String FirstName,String LastName,String emailId , String role,double contact,String Street,String City,int Zipcode,byte[] image,String Status){
       Customer cust = new Customer();
       cust.setFirstname(FirstName);
       cust.setEmail(emailId);
       cust.setRole(role);
       cust.setLastname(LastName);
       cust.setContact(contact);
       cust.setStreet(Street);
       cust.setCity(City);
       cust.setZipCode(Zipcode);
       cust.setImagetry(image);
       cust.setStatus(Status);
       customerList.add(cust);
       return cust;
     }
}
