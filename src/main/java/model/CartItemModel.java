package model;

public class CartItemModel {
    private ProductModel item;
    private  int quantity;

    public void setItem(ProductModel item) {
        this.item = item;
    }

    public ProductModel getItem() {
        return item;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}
