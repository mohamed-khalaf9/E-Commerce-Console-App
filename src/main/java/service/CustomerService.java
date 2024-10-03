package service;

import model.UserModel;

public class CustomerService {
    private UserModel curCustomer;

    public CustomerService(UserModel curCustomer) {
        this.curCustomer = curCustomer;
    }
}
