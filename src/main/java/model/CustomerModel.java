package model;

import java.util.HashMap;

public class CustomerModel {
    private CartModel customerCart;
    private Map <Integer ,OrderModel> customerOrders;


    public void setCustomerCart(CartModel _customerCart) {
        customerCart = _customerCart;
    }

    public CartModel getCustomerCart() {
        return customerCart;
    }

    public void setCustomerOrders(OrderModel order) {
         customerOrders.put(OrderModel.getId(),order);
    }

    public HashMap<Integer, OrderModel> getCustomerOrders() {
        return customerOrders;
    }
}
