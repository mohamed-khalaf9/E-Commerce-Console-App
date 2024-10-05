package model;

import java.util.HashMap;
import java.util.Map;

public class CartModel {
    private static int cartItemNumber = 0;
    private Map<Integer,CartItemModel> cartItems;
    private double totalPrice;

    public CartModel(){
        this.cartItemNumber=++cartItemNumber;
        this.cartItems= new HashMap<>();
    }
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setCartItems( CartItemModel Item) {
        cartItems.put(cartItemNumber,Item);
    }

    public Map<Integer, CartItemModel> getCartItems() {
        return cartItems;
    }
}
