package model;

import java.util.HashMap;

public class CartModel {
    private static int cartItemNumber = 1;
    private HashMap<Integer,CartItemModel> cartItems;
    private double totalPrice;

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setCartItems( CartItemModel Item) {
        cartItems.put(cartItemNumber++,Item);
    }

    public HashMap<Integer, CartItemModel> getCartItems() {
        return cartItems;
    }
}
