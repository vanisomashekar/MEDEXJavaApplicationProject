/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;


import Business.Role.Role;
import Business.Role.SupOrderManager;
import java.util.ArrayList;

/**
 *
 * @author Harshitha
 */
public class SupplierSalesOrganization extends Organization{
    
    public SupplierSalesOrganization() {
        super(Organization.Type.SupplierSales.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new SupOrderManager());
        return roles;
    }
    
}
