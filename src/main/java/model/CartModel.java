package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CartModel {
    private  int cartItemNumber = 0;
   // private Map<Integer,CartItemModel> cartItems;
    private ArrayList< CartItemModel> cartItems;
    private double totalPrice;

    public CartModel(){
        this.cartItemNumber=++cartItemNumber;
        //this.cartItems= new HashMap<>();
        this.cartItems=new ArrayList<>();
    }
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setCartItems( CartItemModel Item) {

        //cartItems.put(cartItemNumber++,Item);
        cartItems.add(Item);
    }

    /* public Map<Integer, CartItemModel> getCartItems() {
        return cartItems;
    }*/
    public ArrayList<CartItemModel> getCartItems(){
        return cartItems;
    }
}
