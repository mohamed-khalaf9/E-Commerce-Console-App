package service;

import factory.PaymentMethodFactory;
import model.*;
import payment.PaymentMethod;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CustomerService {
    private CustomerModel curCustomer;


    public CustomerService(CustomerModel curCustomer) {

        this.curCustomer = curCustomer;

    }

    public ProductModel[] BrowseProducts(String category) {
        return ProductService.getInstance().getProductsOfCategory(category);

    }

    public boolean addToCart(ProductModel product, int quantity) {
        try {
            if (quantity > product.getStock_quantity()) {
                throw new IllegalArgumentException("this quantity is greater than stock amount");
            } else {
                CartItemModel item = new CartItemModel(product, quantity);

                if (curCustomer.getCustomerCart().isExist(item))
                    throw new IllegalArgumentException("this item is already exists");

                else {
                    curCustomer.getCustomerCart().addItem(item);
                    return true;
                }
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public ArrayList<String> getCartItemsInfo (){
        ArrayList<String> items = new ArrayList<>();
        try {

            if (curCustomer.getCustomerCart().getCartItems().size() == 0)
                throw new IllegalArgumentException("No items found to view ");

            for (int i = 0; i < curCustomer.getCustomerCart().getCartItems().size(); i++) {
                items.add(curCustomer.getCustomerCart().getCartItems().get(i).ToString());
            }
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());

        }
        return items;
    }

    public CartItemModel getCarttemByNumber(int productNumber){
        return curCustomer.getCustomerCart().getCartItems().get(productNumber);

    }

    public String getTotalPrice(){
        String str="Total price:  $"+curCustomer.getCustomerCart().getTotalPrice();
        return str;

    }
    public boolean checkout(String paymentMethod){
        if (paymentMethod=="Pay on delivery") {
            OrderModel order =new OrderModel(curCustomer.getEmail(),curCustomer.getCustomerCart().getCartItems(),curCustomer.getCustomerCart().getTotalPrice(),paymentMethod);
            curCustomer.setCustomerOrders(order);
            OrderService.getInstance().setOrder(order);
            curCustomer.getCustomerCart().reduceStockQuantity();
            curCustomer.getCustomerCart().getCartItems().clear();
            return true;
        }
        else {
            boolean ok = handelPaymentMethod(paymentMethod);
            if (ok)
                return true;

            else
                return false;
        }
    }
    private boolean handelPaymentMethod(String methodOfPayment){
        PaymentMethod method = PaymentMethodFactory.createPaymentMethod(methodOfPayment);
        boolean done= method.readData();

        if(done){
            //curCustomer.getCustomerCart().calculateTotalPrice();
            method.processPayment(curCustomer.getCustomerCart().getTotalPrice());
            OrderModel order =new OrderModel(curCustomer.getEmail(),curCustomer.getCustomerCart().getCartItems(),curCustomer.getCustomerCart().getTotalPrice(),methodOfPayment);
            curCustomer.setCustomerOrders(order);
            OrderService.getInstance().setOrder(order);
            curCustomer.getCustomerCart().reduceStockQuantity();
            curCustomer.getCustomerCart().getCartItems().clear();
            return true;
        }
        else
            return false;
    }
    public boolean updateProductQuantity(int productNumber ,int newQuantity ) {
        try {
            if (newQuantity > curCustomer.getCustomerCart().getCartItems().get(productNumber).getItem().getStock_quantity())
                throw new IllegalArgumentException("Quantity exceeds the stock");
            else {
                curCustomer.getCustomerCart().getCartItems().get(productNumber-1).setQuantity(newQuantity);
                return true;
            }
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public void removeProduct(int productNumber){
        curCustomer.getCustomerCart().getCartItems().remove(productNumber-1);
    }


    public ArrayList<String> getOrders(){
        ArrayList<String>orders=new ArrayList<>();
        for(OrderModel order:curCustomer.getCustomerOrders().values()){
            orders.add(order.ToString());
        }

        return orders;
    }


}

   