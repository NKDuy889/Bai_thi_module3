package model;

public class Product {
    private int id;
    private String name;
    private int price;
    private int quantity;
    private String color;
    private String descreption;
    private String category;

    public Product(){};

    public Product(String name, int price, int quantity, String color, String descreption, String category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.descreption = descreption;
        this.category = category;
    }

    public Product(int id, String name, int price, int quantity, String color, String descreption, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.descreption = descreption;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescreption() {
        return descreption;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
