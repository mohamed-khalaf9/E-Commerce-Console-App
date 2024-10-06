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
           if(quantity>product.getStock_quantity()) {
                throw new IllegalArgumentException("this quantity is greater than stock amount");
            }
            else {
                CartItemModel item = new CartItemModel(product, quantity);

                if (curCustomer.getCustomerCart().isExist(item))
                   throw new IllegalArgumentException("this item is already exists");

                 else{
                   curCustomer.getCustomerCart().addItem(item);
                      return true;
                 }
            }

        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
    }



    }

