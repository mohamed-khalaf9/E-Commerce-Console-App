package service;

import model.OrderModel;

import java.util.ArrayList;
import java.util.Map;

import java.util.HashMap;

public class OrderService {
    private Map <Integer , OrderModel> orderId_orderObj;
    private static OrderService instance;
    private OrderService() {
        orderId_orderObj = new HashMap();
    }

    public static OrderService getInstance() {
        if(instance == null) {
            instance = new OrderService();
        }
        return instance;
    }
    public void setOrder(OrderModel order){
        orderId_orderObj.put(order.getId(),order);
    }

    public ArrayList<OrderModel> getAllOrders() {
       ArrayList<OrderModel> orders = new ArrayList<>();
       orders.addAll(orderId_orderObj.values());
       return orders;
    }
}

