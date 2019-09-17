/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;


import Business.Role.ClinicDoctorRole;
import Business.Role.CustomerAdminRole;
import Business.Role.HospitalRole;
import Business.Role.LabRole;
import Business.Role.PharmacyRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Harshitha
 */
public class CustomerServiceOrganization extends Organization{
     public CustomerServiceOrganization() {
        super(Organization.Type.CustomerService.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new CustomerAdminRole());
         roles.add(new HospitalRole());
         roles.add(new PharmacyRole());
         roles.add(new ClinicDoctorRole());
         roles.add(new LabRole());
        return roles;
    }
    
}
