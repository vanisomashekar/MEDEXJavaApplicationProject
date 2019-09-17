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
import Business.userinterface.PharmacyRole.PharmacyWorkAreaJPanel;
import javax.swing.JPanel;
import userinterface.ClinicDoctorRole.ClinicDoctorWorkAreaJPanel;

/**
 *
 * @author Harshitha
 */
public class PharmacyRole extends Role {
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        throw new UnsupportedOperationException("Not supported yet.");
        
    }

    @Override
    public JPanel createCustomerArea(JPanel userProcessContainer, CustomerAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new PharmacyWorkAreaJPanel(userProcessContainer, account, organization, enterprise,business);
    }
    
}
