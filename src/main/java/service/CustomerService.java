package service;

import model.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CustomerService {
    private CustomerModel curCustomer;

    public CustomerService(CustomerModel curCustomer) {
        this.curCustomer = curCustomer;
    }

    public ProductModel[] BrowseProducts (String category){
        return ProductService.getInstance().getProductsOfCategory(category);

    }
    public boolean addToCart (ProductModel product , int quantity){
        try {


            if (quantity <= product.getStock_quantity()) {
                CartItemModel item = new CartItemModel(product, quantity);
                if(curCustomer.getCustomerCart()==null){
                CartModel cart =new CartModel();
                    cart.setCartItems(item);
                    curCustomer.setCustomerCart(cart);
                 }
                else {
                    curCustomer.getCustomerCart().setCartItems(item);
                }
                return true;
            } else {
                throw new IllegalArgumentException("this quantity is greater than stock amount");
            }

        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
