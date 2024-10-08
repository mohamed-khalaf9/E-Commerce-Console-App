package service;

import model.CartItemModel;

import java.util.ArrayList;

public class CartService {
    private ArrayList<CartItemModel> cartItems;
    double totalPrice;
    //private static CartService instance;

    /*private CartService(){
        cartItems=new ArrayList<>();
    }*/
    public CartService (){
        cartItems=new ArrayList<>();
    }

    /*public static CartService getInstance(){
        if(instance==null){
            instance=new CartService();
        }
        return instance;
    }*/
    public ArrayList<CartItemModel> getCartItems(){
        return cartItems;
    }
    public boolean isExist (CartItemModel item){
        for(CartItemModel it :getCartItems()){
            if(it.Equals(item.getItem())) {
                return true;
            }
        }
        return false;
    }
    public void addItem(CartItemModel item){
        cartItems.add(item);
    }
    public void viewItems(){
        for(int i=0;i<cartItems.size();i++){
            System.out.println(cartItems.get(i).getQuantity());
        }
    }
    public void calculateTotalPrice(){
        for(int i=0;i<cartItems.size();i++) {
            totalPrice+=cartItems.get(i).getItem().getPrice();
        }
        }
        public double getTotalPrice(){
        return totalPrice;
    }
    public void reduceStockQuantity(){
        for(int i=0;i<cartItems.size();i++) {
            int newStock=  cartItems.get(i).getItem().getStock_quantity()-cartItems.get(i).getQuantity();
            cartItems.get(i).getItem().setStock_quantity(newStock);
        }
        }
    }

