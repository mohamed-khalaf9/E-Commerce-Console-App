package factory;

import controller.AdminController;
import controller.BaseController;
import controller.CustomerController;
import model.AdminModel;
import model.Role;
import model.UserModel;
import service.AdminService;
import service.CustomerService;

public class ControllerFactory {

    public static BaseController createController(UserModel user) {
        if(user.getRole() == Role.ADMIN)
            return new AdminController(new AdminService(user));
        else if (user.getRole() == Role.CUSTOMER)
            return new CustomerController(new CustomerService(user));


        return null;

    }
}
