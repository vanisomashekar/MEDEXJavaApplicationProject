/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.CustomerAccount.CustomerAccount;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public abstract class Role {
    
    public enum RoleType{
        Admin("Admin"),
        AdDeliveryManager("Admin Delivery Manager"),
        AdOrderManager("Admin Order Manager"),
        CustomerAdminRole("Customer Admin Role"),
        HospitalRole("Hospital"),
        ClinicDoctorRole("Clinic Doctor"),
        PharmacyRole("Pharmacy"),
        LabRole("Lab"),
        SupOrderManager("Supplier Order Manager"),
        SuppliesManager("Supplies Manager"),
        TPDeliveryManager("Third Party Delivery Manager"),
        TPOrderManager("Third Party Order Manager");
        
        
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization, 
            Enterprise enterprise, 
            EcoSystem business);

    public abstract JPanel createCustomerArea(JPanel userProcessContainer, 
            CustomerAccount account, 
            Organization organization, 
            Enterprise enterprise, 
            EcoSystem business);
    
    @Override
    public String toString() {
        return this.getClass().getName();
    }
    
    
}