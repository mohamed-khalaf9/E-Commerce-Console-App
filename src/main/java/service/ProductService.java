package service;

import model.ProductModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProductService {
    private Map<Integer, ProductModel> productId_productObj;
    private Map<String, ArrayList<ProductModel>> category_products;
    private static ProductService instance;

    private ProductService() {
        productId_productObj = new HashMap<>();
        category_products = new HashMap<>();
    }

    public static ProductService getInstance() {
        if (instance == null) {
            instance = new ProductService();
        }

        return instance;
    }

    public boolean addProduct(String name, double price, String description, int quantity, String category) {

        ProductModel newProduct = new ProductModel(name, price, description, category, quantity);
        productId_productObj.put(newProduct.getId(), newProduct);

        if (category_products.containsKey(category)) {
            category_products.get(category).add(newProduct);
        } else {
            category_products.put(category, new ArrayList<>());
            category_products.get(category).add(newProduct);
        }


        return true;

    }
}



