package controller;

import service.CustomerService;
import service.ProductService;
import view.CustomerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerController extends BaseController {
    private CustomerView view;
    private CustomerService service;

    public CustomerController( CustomerService service) {
        this.service = service;
        view=new CustomerView();
    }

    public void run(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> menu= new ArrayList<>();
        menu.add("Browse products");
        menu.add("View cart");
        menu.add("View order history");
        menu.add("Logout");
        while(true)
        {
             int option =view.showMenu(menu,"Please select an option");
              
              switch (option) {
                  case 1:
                      BrowseProducts();
                      break;
                  case 2:
                      //viewCart();
                      break;
                  case 3:
                      //viewOrderHistory();
                      break;
                  case 4:
                      option = -1;
                      break;
              }
        }


    }
    /*
    private void BrowseProducts(){
        try{
            while(true){
                ArrayList<String> lst =ProductService.getInstance().getCategories();
                view.showMenu(lst,"Available Categories");
                int option= view.askForInput("please select an option : ");
                if(option>=lst.size()||option<=0)
                    throw new IllegalArgumentException("choose a proper number");
                else{
                    String category = lst.get(option-1);
                    ArrayList<String> products= new ArrayList<String>();
                    for(int i=0;i<service.BrowseProducts(category).length;i++){
                       // products.add(service.BrowseProducts(category)[i].ToString());
                    }
                    String str= "Available Products in "+category;
                    view.showMenu(products, str);
                    ArrayList<String>options =new ArrayList<String>();
                    options.add("1. Add to cart");
                    options.add("2. Back to categories");
                    options.add("3. Back to menu");
                    view.showMenu(options,"Choose : ");
                    int op=view.askForInput("Select an option");
                        if(op==1){
                          addToCart(category);
                        }

                        else if(op==2)
                            continue;
                            else if(op==3)
                                System.exit(0);
                            else
                            throw new IllegalArgumentException("choose a proper number");


                }
            }
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            BrowseProducts();
        }
    }
    */

    /*
    private void addToCart (String curCategory){
        int[]itemInfo=view.getCartItemInfo();
        int number=itemInfo[0];
        if(number>0&&number<=service.BrowseProducts(curCategory).length);
      boolean succeedded = service.addToCart(service.BrowseProducts(curCategory)[number-1],itemInfo[1]);
      if(succeedded) {
         String name= service.BrowseProducts(curCategory)[itemInfo[0]-1].getName();
          view.informMessage(name+" has been added to your cart");
      }
      else {
          view.informMessage("Enter valid information: ");
          addToCart(curCategory);
      }
    }
    */

}
