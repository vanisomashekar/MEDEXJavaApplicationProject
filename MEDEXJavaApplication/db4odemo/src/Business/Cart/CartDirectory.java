/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Cart;

import java.util.ArrayList;

/**
 *
 * @author vaniv
 */
public class CartDirectory {
    private ArrayList<Cart> cartList;

    public ArrayList<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(ArrayList<Cart> cartList) {
        this.cartList = cartList;
    }
    
    public CartDirectory(){
        cartList = new ArrayList();
    }
    
    public Cart CreateCart(int ID,String name, String desc,double price,int quantity,String type,String supplierName,String productType,byte[] image){
        Cart c = new Cart();
        c.setProductID(ID);
        c.setName(name);
        c.setDesc(desc);
        c.setPrice(price);
        c.setQuantity(quantity);
        c.setType(type);
        c.setSupplierName(supplierName);
        c.setProductType(productType);
        c.setImagetry(image);
        cartList.add(c);
        return c;
    }
    
    public void removeCart(Cart s) {
        cartList.remove(s);
    }
    
    public void removeCartAll(){
        cartList.removeAll(cartList);
    }
}
