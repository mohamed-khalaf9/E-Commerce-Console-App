package service;

import model.ProductModel;

import java.util.ArrayList;
import java.util.HashMap;

public class ProductService {
    private HashMap < Integer , ProductModel> productId_productObj;
    private HashMap <String , ArrayList<ProductModel> > category_products;
    private static ProductService instance;

    public static ProductService getInstance () {
        return  instance;
    }


}
