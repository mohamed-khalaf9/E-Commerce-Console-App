package service;

import factory.UserFactory;
import model.Role;
import model.UserModel;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String , UserModel> users ; // userEmail->UserModelObject
    private UserModel curUser;

    public UserService() {
        users = new HashMap<>();
        curUser = new UserModel();
    }

    public boolean SignUP(String[] info) {
        String name = info[0];
        String email = info[1];
        String password = info[2];
        Role role = Role.CUSTOMER;

        if(users.containsKey(name)) {
            return false;
        }
        UserModel newUser = UserFactory.CreateUser(name,email,password,role);
        users.put(email, newUser);
        curUser = newUser;
        return true;
    }




    public UserModel getCurUser() {
        return curUser;
    }
}
