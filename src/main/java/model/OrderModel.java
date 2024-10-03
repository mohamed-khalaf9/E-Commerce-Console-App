package model;

import java.util.ArrayList;

public class OrderModel {
    private static int id;
    private String customerEmail;
    private ArrayList<CartItemModel> orderProducts;
    private double totalPrice;
    private String paymentMethod;

    public static void setId(int id) {
        OrderModel.id = id;
    }

    public static int getId() {
        return id;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setOrderProducts(CartItemModel item) {
        orderProducts.add(item);
    }

    public ArrayList<CartItemModel> getOrderProducts() {
        return orderProducts;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
}
