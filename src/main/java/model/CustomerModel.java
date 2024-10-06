package model;

import service.CartService;

import java.util.HashMap;
import java.util.Map;

public class CustomerModel extends UserModel{
   // private CartModel customerCart;
      private CartService service;
    private Map<Integer ,OrderModel> customerOrders;

    public CustomerModel(String name,String email,String password ,Role role) {
        super(name,email,password,role);
        customerOrders = new HashMap<>();
        //customerCart = new CartModel();
           //CartService.getInstance();
        service=new CartService();

    }


    /*public void setCustomerCart(CartModel _customerCart) {
        customerCart = _customerCart;
    }*/

    public CartService getCustomerCart() {
        return service;
    }

    public void setCustomerOrders(OrderModel order) {
         customerOrders.put(OrderModel.getId(),order);
    }

   // public HashMap<Integer, OrderModel> getCustomerOrders() {
//return customerOrders;
    //}
}
