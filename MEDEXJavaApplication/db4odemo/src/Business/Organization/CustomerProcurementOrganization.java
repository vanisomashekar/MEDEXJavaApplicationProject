/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.AdDeliveryManager;
import Business.Role.AdOrderManager;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Harshitha
 */
public class CustomerProcurementOrganization extends Organization{
    
    public CustomerProcurementOrganization() {
        super(Organization.Type.CustomerProcurement.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new AdOrderManager());
        roles.add(new AdDeliveryManager());
        return roles;
    }
    
}
