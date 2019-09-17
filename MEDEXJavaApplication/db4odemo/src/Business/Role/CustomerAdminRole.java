/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.CustomerAccount.CustomerAccount;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.AdminRole.CustomerAdminRoleJPanel;
import userinterface.ClinicDoctorRole.ClinicDoctorWorkAreaJPanel;

/**
 *
 * @author vaniv
 */
public class CustomerAdminRole extends Role {
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new CustomerAdminRoleJPanel(userProcessContainer, account, organization, enterprise);
    }

    @Override
    public JPanel createCustomerArea(JPanel userProcessContainer, CustomerAccount customerAccount, Organization organization, Enterprise enterprise, EcoSystem business) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
