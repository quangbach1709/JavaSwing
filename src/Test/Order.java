package Test;

import java.util.Arrays;

public class Order {

    private String orderID;
    private Customer customer;
    //tao danh sach Grocery
    private Grocery[] items;

    public Order(String orderID, Customer customer) {
        this.orderID = orderID;
        this.customer = customer;
        this.items = new Grocery[10];
    }

    public Order(String orderID, Customer customer, Grocery[] items) {
        this.orderID = orderID;
        this.customer = customer;
        this.items = items;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Grocery[] getItems() {
        return items;
    }

    public void setItems(Grocery[] items) {
        this.items = items;
    }

    public void addItem(Grocery item) {
        //them 1 san pham vao danh sach
        //tim vi tri rong dau tien
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                break;
            }
        }
    }

    public double getTotalCost() {
        double total = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                total += items[i].getPrice();
            }
        }
        return total;
    }

    @Override
    public String toString() {
        return "Oder{" +
                "oderID='" + orderID + '\'' +
                ", customer=" + customer +
                ", items=" + Arrays.toString(items) +
                '}';
    }
}
