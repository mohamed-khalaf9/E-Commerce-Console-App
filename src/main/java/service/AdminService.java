package service;

import model.ProductModel;
import model.UserModel;

public class AdminService {
    private UserModel curAdmin;

    public AdminService(UserModel curAdmin) {
        this.curAdmin = curAdmin;
    }

    public boolean addProduct(String name,double price,String description,int quantity,String category)
    {
        ProductService productService = ProductService.getInstance();
        return productService.addProduct(name,price,description,quantity,category);
    }

}
