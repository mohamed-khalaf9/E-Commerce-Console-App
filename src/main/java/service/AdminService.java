package service;

import model.ProductModel;
import model.UserModel;

public class AdminService {
    private UserModel curAdmin;

    public AdminService(UserModel curAdmin) {
        this.curAdmin = curAdmin;
    }

    public boolean addProduct(String name, double price, String description, int quantity, String category) {
        ProductService productService = ProductService.getInstance();
        return productService.addProduct(name, price, description, quantity, category);
    }

    public boolean updateProductPrice(String category, ProductModel productToBeUpdated, double price){
        ProductService productService = ProductService.getInstance();
        return productService.updateProductPrice(category, productToBeUpdated,price);
    }
    public boolean updateProductDescription(String category, ProductModel productToBeUpdated, String description){
        ProductService productService = ProductService.getInstance();
        return productService.updateProductDescription(category, productToBeUpdated,description);
    }
    public boolean updateProductStock(String category, ProductModel productToBeUpdated, int stock){
        ProductService productService = ProductService.getInstance();
        return productService.updateProductStock(category, productToBeUpdated,stock);
    }



}
