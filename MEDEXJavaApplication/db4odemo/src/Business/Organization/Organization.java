/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Buisness.Products.ProductDirectory;
import Business.Customer.CustomerDirectory;
import Business.CustomerAccount.CustomerAccountDirectory;
import Business.Employee.EmployeeDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public abstract class Organization {

    private String name;
    private WorkQueue workQueue;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private CustomerDirectory customerDirectoy;
    private CustomerAccountDirectory customerAccountDirectory;
    private ProductDirectory productDirectory;
    private int organizationID;
    private static int counter=0;
    
    public enum Type{
        Admin("Admin Organization"), 
        CustomerService("Customer Service Organization"), CustomerProcurement("Customer Procurement Organization"),
        SupplierSales("Suplier Sales Organization"), SupplierProcurement("Procurement Organization"),
        TPManagement("TPManagement");
        
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public Organization(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        customerDirectoy = new CustomerDirectory();
        customerAccountDirectory = new CustomerAccountDirectory();
        productDirectory = new ProductDirectory();
        organizationID = counter;
        ++counter;
    }

    public CustomerDirectory getCustomerDirectoy() {
        return customerDirectoy;
    }

    public CustomerAccountDirectory getCustomerAccountDirectory() {
        return customerAccountDirectory;
    }

    public abstract ArrayList<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }
    
    public ProductDirectory getProductDirectory() {
        return productDirectory;
    }

    public void setProductDirectory(ProductDirectory productDirectory) {
        this.productDirectory = productDirectory;
    }
    
    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }
    
    

    @Override
    public String toString() {
        return name;
    }
    
    
}
