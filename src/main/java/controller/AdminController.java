package controller;

import model.ProductModel;
import service.AdminService;
import service.ProductService;
import view.AdminView;

import java.util.ArrayList;

public class AdminController extends BaseController {
    private AdminView view;
    private AdminService service;

    private void addProduct(){
        String name = view.askForStringInput("Enter Product Name: ");
        double price = view.askForDoubleInput("Enter Product Price: ");
        String description = view.askForStringInput("Enter Product Description: ");
        int quantity = view.askForIntInput("Enter Product quantity: ");
        String category = view.askForStringInput("Enter Product Category: (starts with uppercase letter)");


        if(service.addProduct(name,price,description,quantity,category))
            view.showMessage("Product "+name+" has been added to the ("+category+") category successfully!");
        else
            view.showMessage("failed to add product , try again .... ");

    }
    private void updateProduct(){
        String category ="" ;
        int productId = -1;
        int toBeUpdated = -1;

        category = displayCategories();
        if(category=="") return;

        productId = displayProductsOfCategory(category);
        if(productId==-1) return;


        ArrayList<String> menu = new ArrayList<>();
        menu.add("Price");
        menu.add("Description");
        menu.add("Stock");
        toBeUpdated = view.showMenu(menu,"Enter your choice:");

        switch(toBeUpdated){
            case 1:
                double price = view.askForDoubleInput("Enter the new Price: ");

                if( service.updateProductPrice(category,productId,price))
                    view.showMessage("Product has been updated successfully!");
                else
                    view.showMessage("failed to update product , try again .... ");
                break;
            case 2:

                String description = view.askForStringInput("Enter the new Description: ");
                if(service.updateProductDescription(category,productId,description))
                    view.showMessage("Product has been updated successfully!");
                else
                    view.showMessage("failed to update product , try again .... ");
                break;
            case 3:
                int stock = view.askForIntInput("Enter the new Stock: ");
                if(service.updateProductStock(category,productId,stock))
                    view.showMessage("Product has been updated successfully!");
                else
                    view.showMessage("failed to update product , try again .... ");
                break;
        }

    }

    private String displayCategories(){
        String category;
        ProductService productService = ProductService.getInstance();
        ArrayList<String> categories = productService.getCategories();
        if(categories.size()>0){
            int choice = view.showMenu(categories,"Available Categories , Select One: ");
            category = categories.get(--choice);
            return category;
        }
        else{
            view.showMessage("No categories found");
            return "";
        }
    }

    private int displayProductsOfCategory(String category) {
        int productId = -1;
        ProductService productService = ProductService.getInstance();

        ArrayList<String> productsToBeDisplayed = new ArrayList<>();
        ProductModel[] productsOfCategory = productService.getProductsOfCategory(category);

        if (productsOfCategory.length <= 0) {
            view.showMessage("No products found");
            return -1;
        } else {
            for (ProductModel product : productsOfCategory) {
                productsToBeDisplayed.add(product.getName() + " - " + product.getPrice() + " - stock: " + product.getStock_quantity());
            }

            int productNumber = view.showMenu(productsToBeDisplayed, "Available Products in " + category + ", Please Select Product Number: ");

            ProductModel productToBeUpdated = productsOfCategory[productNumber - 1];
            productId = productToBeUpdated.getId();
            return productId;
        }
    }


    private void removeProduct(){
        String category = "";
        int productId = 0;

        category = displayCategories();
        if(category=="") return;

        productId = displayProductsOfCategory(category);
        if(productId==-1) return;

        if(view.confirmationMessage("Are you sure you want to remove iPhone 15? (Y/N):") == 'Y') {
           if(service.removeProduct(category, productId))
           {
               view.showMessage("Product "+productId+" has been removed successfully!");
           }
           else
               view.showMessage("failed to remove product , try again .... ");
        }
        else
            return;

    }
    private void viewOrders(){

    }
    private void manageInventory(){

    }



    public AdminController( AdminService service) {
        this.service = service;
        view = new AdminView();
    }

    public void run(){
        boolean isRunning = true;

        while(isRunning) {
            ArrayList<String> menu = new ArrayList<>();
            menu.add("Add Product");
            menu.add("Update Product Information");
            menu.add("Remove Product");
            menu.add("View Orders");
            menu.add("Manage Inventory");
            menu.add("Logout");

            int option = view.showMenu(menu, "Please select an option: ");
            switch (option) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    updateProduct();
                    break;
                case 3:
                    removeProduct();
                    break;
                case 4:
                    viewOrders();
                    break;
                case 5:
                    manageInventory();
                    break;
                case 6:
                    isRunning = false;
                    break;

            }

        }

    }
}
