/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.CustomerAccount;

import Business.Customer.Customer;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author vaniv
 */
public class CustomerAccountDirectory {
    private ArrayList<CustomerAccount> customerAccountList;

    public CustomerAccountDirectory() {
        customerAccountList = new ArrayList();
    }

    public ArrayList<CustomerAccount> getUserAccountList() {
        return customerAccountList;
    }
    
    public CustomerAccount authenticateUser(String username, String password){
        for (CustomerAccount ua : customerAccountList)
            if (ua.getUsername().equals(username) && ua.getPassword().equals(password)){
                return ua;
            }
        return null;
    }
    
    public CustomerAccount createUserAccount(String username, String password, Customer customer, Role role){
        CustomerAccount userAccount = new CustomerAccount();
        userAccount.setUsername(username);
        userAccount.setPassword(password);
        userAccount.setCustomer(customer);
        userAccount.setRole(role);
        customerAccountList.add(userAccount);
        return userAccount;
    }
    
    public boolean checkIfUsernameIsUnique(String username){
        for (CustomerAccount ua : customerAccountList){
            if (ua.getUsername().equals(username))
                return false;
        }
        return true;
    }
}
