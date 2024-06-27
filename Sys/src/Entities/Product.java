package Entities;
public class Product {
    
    private final String code;
    private final String name;
    private final int stock;
    private final Double price;
    private final String NameProvider;
    private final String date;

    public Product(String code, String name, int stock, Double price, String NameProvider, String date) {
        this.code = code;
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.NameProvider = NameProvider;
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public Double getPrice() {
        return price;
    }

    public String getNameProvider() {
        return NameProvider;
    }

    public String getDate() {
        return date;
    }
    
    
}
