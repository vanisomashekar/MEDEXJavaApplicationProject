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
import userinterface.AdOrderManagerRole.AdOrderManagerWorkAreaJPanel;
import userinterface.AdOrderManagerRole.AdminOrderManagerJPanel;


/**
 *
 * @author Harshitha
 */
public class AdOrderManager extends Role{
     @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new AdminOrderManagerJPanel(userProcessContainer, account, organization, enterprise,business);
    }

    @Override
    public JPanel createCustomerArea(JPanel userProcessContainer, CustomerAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
