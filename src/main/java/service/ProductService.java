package service;

import model.ProductModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProductService {
    private Map < Integer , ProductModel> productId_productObj;
    private Map <String , ArrayList<ProductModel> > category_products;
    private static ProductService instance;
    private ProductService() {
        productId_productObj = new HashMap<>();
        category_products = new HashMap<>();
    }

    public static ProductService getInstance () {
        return  instance;
    }


}
