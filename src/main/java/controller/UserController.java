package controller;

import model.UserModel;
import service.UserService;
import view.UserView;

public class UserController {
    private UserView view;
    private UserService service;
    private UserModel currUser;

    private boolean signUP(){
        String[] userInfo = view.getSignUpInfo();
        return service.SignUP(userInfo);
    }
    private boolean login(){
        String[] loginInfo = view.getLoginInfo();
        return service.login(loginInfo);
    }

    public UserController() {
        view = new UserView();
        service = new UserService();
        currUser = new UserModel();
    }

    public UserModel accessSystem() {
        try {
            while (true) {
                boolean isAccessSuccess = false;
                int option = view.startMenu();

                switch (option) {
                    case 1:
                        isAccessSuccess = signUP();
                        if (isAccessSuccess) {
                            currUser = service.getCurUser();
                            view.showMessage("Sign Up Successful!");
                            return currUser;
                        }
                        else {
                            view.showMessage("User already exist , try again ...");
                            continue;
                        }

                    case 2:
                        isAccessSuccess = login();
                        if (isAccessSuccess) {
                            currUser = service.getCurUser();
                            view.showMessage("Login Successful! Welcome, "+ currUser.getName());
                            return currUser;
                        }
                        else {
                            view.showMessage(" Email or Password is not correct , try again ...");
                            continue;
                        }

                    case 3:
                        throw new Exception();

                }

            }
        } catch (Exception e) {
            System.out.println("Exit successfully.");
            System.exit(0);
        }

        return currUser;


    }
}


