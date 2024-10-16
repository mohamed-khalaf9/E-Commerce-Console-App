package controller;

import model.OrderModel;
import service.CustomerService;
import service.ProductService;
import view.CustomerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerController extends BaseController {
    private CustomerView view;
    private CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
        view = new CustomerView();
    }

    public void run() {

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> menu = new ArrayList<>();
        menu.add("Browse products");
        menu.add("View cart");
        menu.add("View order history");
        menu.add("Logout");
        while (true) {

            int option = view.showMenu(menu, "Please select an option");

            switch (option) {
                case 1:
                    BrowseProducts();
                    break;
                case 2:
                    viewCart();
                    break;
                case 3:
                    viewOrderHistory();
                    break;
                case 4:

                    return;
                // break;
            }
        }

    }

    private void BrowseProducts() {
        while (true) {
            ArrayList<String> lst = ProductService.getInstance().getCategories();
            int option = view.showMenu(lst, "Available Categories ,Select category");


            String category = lst.get(option - 1);
            ArrayList<String> products = new ArrayList<String>();
            for (int i = 0; i < service.BrowseProducts(category).length; i++) {
                products.add(service.BrowseProducts(category)[i].TOString());
            }
            String str = "Diplaying Products in " + category;
            boolean found = view.showCategoryProducts(products, str);
            if (found) {
                ArrayList<String> options = new ArrayList<String>();
                options.add("Add to cart");
                options.add("Back to categories");
                options.add("Back to menu");
                int op = view.showMenu(options, "Pleae select an option : ");

                if (op == 1) {
                    addToCart(category);
                } else if (op == 2)
                    continue;
                else if (op == 3)
                    return;

            } else {
                System.out.println("No products found in this category");
                BrowseProducts();
            }


        }
    }


    private void addToCart(String curCategory) {
        int[] itemInfo = view.getCartItemInfo();
        int number = itemInfo[0];
        if (number > 0 && number <= service.BrowseProducts(curCategory).length) {
            boolean succeedded = service.addToCart(service.BrowseProducts(curCategory)[number - 1], itemInfo[1]);
            if (succeedded) {
                String name = service.BrowseProducts(curCategory)[number - 1].getName();
                view.informMessage(name + " has been added to your cart");
            } else {
                view.informMessage(" process failed");
                addToCart(curCategory);
            }
        } else {
            view.informMessage("Enter valid number: ");
            addToCart(curCategory);
        }
    }

    private void viewCart() {
        try {
            ArrayList<String> items = new ArrayList<>();
            items = service.getCartItemsInfo();
            if (items.size() == 0)
                throw new IllegalArgumentException("Add products first to be able to order them");
            else {
                view.printCartItems(items, "Your cart :");
                String str = service.getTotalPrice();
                view.printTotalPrice(str);

                ArrayList<String> menu = new ArrayList<>();
                menu.add("Checkout");
                menu.add("Modify cart");
                menu.add("Back to menu");

                int option = view.showMenu(menu, "Please select an option");
                switch (option) {
                    case 1:
                        checkout(items);
                        break;
                    case 2:
                        modifyCart(items);
                        break;
                    case 3:
                        return;
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

    }

    private void checkout(ArrayList<String> cartItems) {
        view.printCartItems(cartItems, "You are about to order the following: ");
        String str = service.getTotalPrice();
        view.printTotalPrice(str);
        char ch = view.confirmationMessage();
        if (ch == 'y' || ch == 'Y') {
            ArrayList<String> menu = new ArrayList<>();
            menu.add("Debit card");
            menu.add("credit card");
            menu.add("Pay on delivery");

            int option = view.showMenu(menu, "Select a payment method");
            String method = menu.get(option - 1);
            boolean succedded = service.checkout(method);

            if (succedded)
                view.informMessage("Payment successfull! your order has been placed");
            else {
                view.informMessage("payment failed");
                return;
            }
        }


    }

    private void modifyCart(ArrayList<String> lst) {
        try {

            view.printCartItems(lst, "Your cart: ");
            int productNumber = view.askForInput("Select the product number to modify");

            if (productNumber > lst.size() || productNumber < 1)
                throw new IllegalArgumentException("Enter a valid number");
            else {
                String productName = service.getCarttemByNumber(productNumber-1).getItem().getName();
                ArrayList<String> menu = new ArrayList<>();
                menu.add("Update Qte Quantity");
                menu.add("Remove from cart");
                int choice = view.showMenu(menu, "Choose an action");
                if (choice == 1) {
                    int newQuantity = view.askForInput("Enter the new Quantity");
                    boolean ok = service.updateProductQuantity(productNumber,newQuantity);
                    if (ok)
                        view.informMessage(productName + " quantity updated to " + newQuantity);
                    else
                        view.informMessage("process failed!");
                } else {
                    service.removeProduct(productNumber);
                    view.informMessage(productName + " has been removed successfully");
                }

            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            modifyCart(lst);
        }
    }
    private void viewOrderHistory(){
        try {
            ArrayList<String> lst = service.getOrders();
            if(lst.size()==0)
                throw new IllegalArgumentException("There is not any order to view");
            else
            view.printOrders(lst, "Your orders: ");
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }

    }
}


