package Test;

import java.time.LocalDate;

public class Grocery {
    private String name;
    private double price;
    private String expirationDate;

    public Grocery(String name, double price, String expirationDate) {
        this.name = name;
        this.price = price;
        this.expirationDate = expirationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getDetails() {
        return "Name: " + name + ", Price: " + price + ", Expiration Date: " + expirationDate;
    }

    @Override
    public String toString() {
        return "Grocery{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", expirationDate='" + expirationDate + '\'' +
                '}';
    }
}