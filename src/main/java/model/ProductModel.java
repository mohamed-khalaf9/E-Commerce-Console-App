package model;

public class ProductModel {
    private  int id ;
    private  static int  idCounter = 1;
    private String name;
    private double price;
    private String descreption;
    private String category;
    private int stock_quantity;

    public ProductModel(String name, double price, String descreption, String category, int stock_quantity)
    {
        setName(name);
        setPrice(price);
        setDescreption(descreption);
        setCategory(category);
        setStock_quantity(stock_quantity);
        this.id = idCounter++;
    }



    public  int getId() {
        return id;
    }
    public void setName (String _name) {
        name= _name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double _price) {
        price = _price;
    }

    public double getPrice() {
        return price;
    }

    public void setDescreption(String _descreption) {
        descreption = _descreption;
    }

    public String getDescreption() {
        return descreption;
    }

    public void setCategory(String _category) {
        category = _category;
    }

    public String getCategory() {
        return category;
    }

    public void setStock_quantity(int _stock_quantity) {
        stock_quantity = _stock_quantity;
    }

    public int getStock_quantity() {
        return stock_quantity;
    }
}
