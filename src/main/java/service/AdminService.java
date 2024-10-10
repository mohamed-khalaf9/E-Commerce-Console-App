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

    public boolean updateProductPrice(String category, int productId, double price){
        ProductService productService = ProductService.getInstance();
        return productService.updateProductPrice(category, productId,price);
    }
    public boolean updateProductDescription(String category,int productId, String description){
        ProductService productService = ProductService.getInstance();
        return productService.updateProductDescription(category, productId,description);
    }
    public boolean updateProductStock(String category,int productId, int stock){
        ProductService productService = ProductService.getInstance();
        return productService.updateProductStock(category,productId,stock);
    }

    public boolean removeProduct(String category,int productId)
    {
        ProductService productService = ProductService.getInstance();
        return productService.removeProduct(category,productId);
    }



}
