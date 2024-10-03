package controller;

import service.CustomerService;
import view.CustomerView;

import java.util.Scanner;

public class CustomerController extends BaseController {
    private CustomerView view;
    private CustomerService service;

    public CustomerController( CustomerService service) {
        this.service = service;
    }

    public void run(){
        Scanner scanner = new Scanner(System.in);
        while(true)
        {

        }

    }

}
