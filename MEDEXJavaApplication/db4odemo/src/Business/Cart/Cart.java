/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Cart;

/**
 *
 * @author vaniv
 */
public class Cart {
    private String name;
    private int ProductID;
    private int ItemID;
    private String desc;
    private double price;
    private int quantity;
    //private Icon img;
    //private ImageIcon image;
    private String type;
    private String supplierName;
    private String productType;
    private static int count = 1;
    private byte[] imagetry;

    public byte[] getImagetry() {
        return imagetry;
    }

    public void setImagetry(byte[] imagetry) {
        this.imagetry = imagetry;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }
    
    public Cart(){
        ItemID = count;
        count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ItemID;
    }

    public void setID(int ID) {
        this.ItemID = ID;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
    
}
