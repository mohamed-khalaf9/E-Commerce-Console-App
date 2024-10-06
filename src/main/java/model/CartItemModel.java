package model;

public class CartItemModel {
    private ProductModel item;
    private  int quantity;
   public CartItemModel(ProductModel product , int quantity){
        setItem(product);
        setQuantity(quantity);
    }

    public void setItem(ProductModel item) {
        this.item = item;
    }

    public ProductModel getItem() {
        return item;
    }
    public boolean Equals (ProductModel item){
       if(this.item==item)
           return true;
       else
           return false;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}
