package org.example;

import controller.UserController;
import model.UserModel;
import view.UserView;

public class ECommerce {
    private UserController controller;
    private UserModel curUser;

    public ECommerce(){
        controller = new UserController();
        curUser = new UserModel();
    }
    public void run(){
        while(true)
        {
            curUser = controller.accessSystem();

        }
    }





}
