/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Buisness.Products;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Harshitha
 */
public class ProductDirectory {
    
     private List<Product> drugproductlist;
     private List<Product> equipproductlist;
     private List<Product> vaccineproductlist;
    private List<Product> allProducts;

    public List<Product> getAllProducts() {
        return allProducts;
    }

    public void setAllProducts(List<Product> allProducts) {
        this.allProducts = allProducts;
    }
     
     public ProductDirectory()
     {
          drugproductlist=new ArrayList<Product>();
          equipproductlist=new ArrayList<Product>();
          vaccineproductlist=new ArrayList<Product>();
          allProducts = new ArrayList<Product>();
     }

   
    public void deleteProduct(Product prod){
        allProducts.remove(prod);
    }
       public void addDrug(Product prod){
    drugproductlist.add(prod);
      }
      
      public void deleteDrug(Product prod){
          
        drugproductlist.remove(prod);
    }
      
       public void addEquipment(Product prod){
    equipproductlist.add(prod);
      }
      
      public void deleteEquipment(Product prod){
          
        equipproductlist.remove(prod);
    }
      
       public void addVaccine(Product prod){
    vaccineproductlist.add(prod);
      }
      
      public void deleteVaccine(Product prod){
        vaccineproductlist.remove(prod);
    }
      
      
      
      public List<Product> getDrugproductlist() {
          
        return drugproductlist;
    }

    public void setDrugproductlist(List<Product> drugproductlist) {
        this.drugproductlist = drugproductlist;
    }

    public List<Product> getEquipproductlist() {
        return equipproductlist;
    }

    public void setEquipproductlist(List<Product> equipproductlist) {
        this.equipproductlist = equipproductlist;
    }

    public List<Product> getVaccineproductlist() {
        return vaccineproductlist;
    }

    public void setVaccineproductlist(List<Product> vaccineproductlist) {
        this.vaccineproductlist = vaccineproductlist;
    }
     
     
}
