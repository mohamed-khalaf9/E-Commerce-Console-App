package service;

import model.CartItemModel;
import model.CartModel;
import model.ProductModel;
import model.UserModel;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CustomerService {
    private UserModel curCustomer;

    public CustomerService(UserModel curCustomer) {
        this.curCustomer = curCustomer;
    }

    public ProductModel[] BrowseProducts (String category){
        return ProductService.getInstance().getProductsOfCategory(category);

    }
    public boolean addToCart (ProductModel product , int quantity){
        try {


            if (quantity <= product.getStock_quantity()) {
                CartItemModel item = new CartItemModel(product, quantity);
                CartModel cart =new CartModel();
                cart.setCartItems(item);
                curCustomer.setCustomerCart(cart);
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
