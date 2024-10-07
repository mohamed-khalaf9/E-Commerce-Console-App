package service;

import model.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CustomerService {
    private CustomerModel curCustomer;


    public CustomerService(CustomerModel curCustomer) {

        this.curCustomer = curCustomer;

    }

    public ProductModel[] BrowseProducts(String category) {
        return ProductService.getInstance().getProductsOfCategory(category);

    }
}
   