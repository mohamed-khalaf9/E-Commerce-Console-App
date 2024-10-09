package model;

import java.util.ArrayList;
import java.util.Arrays;

public class OrderModel {
    private int id;
    private static int idCounter = 1;
    private String customerEmail;
    private ArrayList<CartItemModel> orderProducts;
    private double totalPrice;
    private String paymentMethod;


    public OrderModel(String customerEmail, ArrayList<CartItemModel> orderProducts, double totalPrice, String paymentMethod) {
       this. orderProducts = new ArrayList<>();
        this.id = idCounter++;
        setCustomerEmail(customerEmail);
        setTotalPrice(totalPrice);
        setPaymentMethod(paymentMethod);
        setOrderProducts(orderProducts);

    }

    public int getId() {
        return id;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setOrderProducts(ArrayList<CartItemModel> products) {
        for (CartItemModel cartItem : products) {
            this.orderProducts.add(cartItem);
        }
    }


    public ArrayList<CartItemModel> getOrderProducts() {
        if(orderProducts==null)
            return new ArrayList<>();
        else
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

    public String ToString() {
        ArrayList<String> products = new ArrayList<>();
        for (CartItemModel item : getOrderProducts()) {
            products.add(item.ToString());
        }
        String productStr = String.join("\n", products);
        String str = "Order ID: " + getId() + "\n Products:" + productStr + "\nTotal price: $" + getTotalPrice() + "\nPayment method: " + getPaymentMethod();
        return str;
    }

}
