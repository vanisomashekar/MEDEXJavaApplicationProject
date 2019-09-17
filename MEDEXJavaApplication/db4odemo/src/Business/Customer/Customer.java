/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author vaniv
 */
public class Customer {
    private int id;
    private String Firstname;
    private String Lastname;
    private double contact;
    private String Street;

    public String getStreet() {
        return Street;
    }

    public void setStreet(String Street) {
        this.Street = Street;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }
    private String City;
    private int ZipCode;
    private Icon license;
    private String Status;
    private String email;
    private String role;
    private Payment payment;
    private byte[] imagetry;

    public byte[] getImagetry() {
        return imagetry;
    }

    public void setImagetry(byte[] imagetry) {
        this.imagetry = imagetry;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    private static int count = 1;
    
    public Customer() {
        id = count;
        payment = new Payment();
        count++;
    }
    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    public double getContact() {
        return contact;
    }

    public void setContact(double contact) {
        this.contact = contact;
    }

    public int getZipCode() {
        return ZipCode;
    }

    public void setZipCode(int ZipCode) {
        this.ZipCode = ZipCode;
    }

    public Icon getLicense() {
        return license;
    }

    public void setLicense(Icon license) {
        this.license = license;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Customer.count = count;
    }

    @Override
    public String toString() {
        return Firstname;
    }


}
