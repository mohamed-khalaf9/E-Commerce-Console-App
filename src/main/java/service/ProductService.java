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

    public ArrayList<String> getCategories() {
        ArrayList<String> categories = new ArrayList<>(category_products.keySet());
        return categories;
    }

    public ProductModel[] getProductsOfCategory(String category) {
        if (category_products.containsKey(category)) {
            ArrayList<ProductModel> productsList = category_products.get(category);
            ProductModel[] productsArray = productsList.toArray(new ProductModel[productsList.size()]);
            return productsArray;
        } else {
            return new ProductModel[0];
        }
    }

    public boolean updateProductPrice(String category, ProductModel productToBeUpdated, double price) {
        int productId = productToBeUpdated.getId();
        boolean isCategoryUpdated = false;
        if (category_products.containsKey(category)) {
            ArrayList<ProductModel> productsInCategory = category_products.get(category);
            for (ProductModel product : productsInCategory) {
                if (product.getId() == productId) {
                    product.setPrice(price);
                    isCategoryUpdated = true;
                    break;
                }
            }
        }
        else return false;

        if (productId_productObj.containsKey(productId) && isCategoryUpdated) {
            productId_productObj.get(productId).setPrice(price);
            return true;
        }
        else
            return false;
    }

    public boolean updateProductDescription(String category, ProductModel productToBeUpdated, String description) {
        int productId = productToBeUpdated.getId();
        boolean isCategoryUpdated = false;
        if (category_products.containsKey(category)) {
            ArrayList<ProductModel> productsInCategory = category_products.get(category);
            for (ProductModel product : productsInCategory) {
                if (product.getId() == productId) {
                    product.setDescreption(description);
                    isCategoryUpdated = true;
                    break;
                }
            }
        }
        else return false;

        if (productId_productObj.containsKey(productId) && isCategoryUpdated) {
            productId_productObj.get(productId).setDescreption(description);
            return true;
        }
        else
            return false;
    }

    public boolean updateProductStock(String category, ProductModel productToBeUpdated, int stock) {
        int productId = productToBeUpdated.getId();
        boolean isCategoryUpdated = false;
        if (category_products.containsKey(category)) {
            ArrayList<ProductModel> productsInCategory = category_products.get(category);
            for (ProductModel product : productsInCategory) {
                if (product.getId() == productId) {
                    product.setStock_quantity(stock);
                    isCategoryUpdated = true;
                    break;
                }
            }
        }
        else return false;

        if (productId_productObj.containsKey(productId) && isCategoryUpdated) {
            productId_productObj.get(productId).setStock_quantity(stock);
            return true;
        }
        else
            return false;
    }

    public boolean removeProduct(String category,int productId){
        boolean isCategoryUpdated = false;

        if (category_products.containsKey(category)) {
            ArrayList<ProductModel> productsInCategory = category_products.get(category);
            for (ProductModel product : productsInCategory) {
                if (product.getId() == productId) {
                    category_products.get(category).remove(product);
                    isCategoryUpdated = true;
                    break;
                }
            }
        }
            if(isCategoryUpdated && productId_productObj.containsKey(productId))
            {
                productId_productObj.remove(productId);
                return true;
            }
            else
                return false;


        }





}



