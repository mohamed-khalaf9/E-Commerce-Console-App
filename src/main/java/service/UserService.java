package service;

import factory.UserFactory;
import model.Role;
import model.UserModel;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String , UserModel> users ; // userEmail->UserModelObject
    private UserModel curUser;

    private void loadAdmins(){
        UserModel admin1 = UserFactory.CreateUser("mohamed","mohamed00@gmail.com","19",Role.ADMIN);
        users.put(admin1.getEmail(), admin1);
    }

    public UserService() {
        users = new HashMap<>();
        curUser = new UserModel();
        loadAdmins();
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

    public boolean login(String[] info) {
        String email = info[0];
        String password = info[1];

        if(!users.containsKey(email)) {
            return false;
        }
        UserModel user = users.get(email);
        if(password.equals(user.getPassword())) {
            curUser = user;
            return true;
        }
        else {
            return false;
        }

    }




    public UserModel getCurUser() {
        return curUser;
    }
}
