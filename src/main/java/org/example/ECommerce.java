package org.example;

import controller.BaseController;
import controller.UserController;
import factory.ControllerFactory;
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
            BaseController controller2 = ControllerFactory.createController(curUser);
            controller2.run();



        }
    }





}
