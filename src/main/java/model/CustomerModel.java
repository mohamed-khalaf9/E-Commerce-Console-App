package model;

import java.util.HashMap;
import java.util.Map;

public class CustomerModel extends UserModel{
    private CartModel customerCart;
    private Map<Integer ,OrderModel> customerOrders;

    public CustomerModel(String name,String email,String password ,Role role) {
        super(name,email,password,role);
        customerOrders = new HashMap<>();
        customerCart = new CartModel();

    }


    public void setCustomerCart(CartModel _customerCart) {
        customerCart = _customerCart;
    }

    public CartModel getCustomerCart() {
        return customerCart;
    }

    public void setCustomerOrders(OrderModel order) {
         customerOrders.put(OrderModel.getId(),order);
    }

   // public HashMap<Integer, OrderModel> getCustomerOrders() {
//return customerOrders;
    //}
}
