package service;

import model.OrderModel;

import java.util.HashMap;

public class OrderService {
    private HashMap <Integer , OrderModel> orderId_orderObj;
    private static OrderService instance;

    public static OrderService getInstance() {
        return instance;
    }
}

