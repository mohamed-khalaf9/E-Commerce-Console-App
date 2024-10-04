package controller;

import service.AdminService;
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

    }
    private void removeProduct(){

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
