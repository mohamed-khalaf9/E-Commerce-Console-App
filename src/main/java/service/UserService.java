package service;

import model.UserModel;

import java.util.HashMap;

public class UserService {
    private Map<String , UserModel> users;
    private UserModel curUser;

    public UserModel getCurUser() {
        return curUser;
    }
}
