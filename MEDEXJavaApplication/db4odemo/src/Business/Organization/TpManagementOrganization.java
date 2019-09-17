/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;


import Business.Role.Role;
import Business.Role.TPDeliveryManager;
import Business.Role.TPOrderManager;
import java.util.ArrayList;

/**
 *
 * @author Harshitha
 */
public class TpManagementOrganization extends Organization{
     public TpManagementOrganization() {
        super(Organization.Type.TPManagement.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new TPDeliveryManager());
        roles.add(new TPOrderManager());
        
        return roles;
    }
    
}
