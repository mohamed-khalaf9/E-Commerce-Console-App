package service;

import model.UserModel;

public class AdminService {
    private UserModel curAdmin;

    public AdminService(UserModel curAdmin) {
        this.curAdmin = curAdmin;
    }
}
