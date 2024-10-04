package controller;

import service.AdminService;
import view.AdminView;

import java.util.ArrayList;

public class AdminController extends BaseController {
    private AdminView view;
    private AdminService service;

    public AdminController( AdminService service) {
        this.service = service;
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
