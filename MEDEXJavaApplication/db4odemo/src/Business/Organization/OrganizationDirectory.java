/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        
         if (type.getValue().equals(Type.CustomerProcurement.getValue())){
            organization = new CustomerProcurementOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.CustomerService.getValue())){
            organization = new CustomerServiceOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.SupplierProcurement.getValue())){
            organization = new SupplierProcurementOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.SupplierSales.getValue())){
            organization = new SupplierSalesOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.TPManagement.getValue())){
            organization = new TpManagementOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
}