package controller;

import service.AdminService;
import view.AdminView;

public class AdminController extends BaseController {
    private AdminView view;
    private AdminService service;

    public AdminController( AdminService service) {
        this.service = service;
    }

    public void run(){

    }
}
