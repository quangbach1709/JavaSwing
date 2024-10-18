package Test;

import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class XLArray {
    private Connection connection;

    public XLArray() {
        try {
            String url = "jdbc:mysql://localhost:3306/javatest";
            connection = DriverManager.getConnection(url, "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Order> getAllOdersByCustomer(ArrayList<Order> orders, String custumerid) {
        List<Order> list = new ArrayList<>();
        for (Order order : orders) {
            if (order.getCustomer().getId().equals(custumerid)) {
                list.add(order);
            }
        }
        return list;

    }

    public void updateOrder(Order order) {
        String query = "UPDATE orders SET customerName = ?, customerId = ?, itemName = ?, itemPrice = ?, itemExpiration = ? WHERE orderID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, order.getCustomer().getName());
            stmt.setString(2, order.getCustomer().getId());
            for (Grocery item : order.getItems()) {
                stmt.setString(3, item.getName());
                stmt.setDouble(4, item.getPrice());
                stmt.setString(5, item.getExpirationDate());
            }
            stmt.setString(6, order.getOrderID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM orders";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Customer customer = new Customer(rs.getString("customerName"), rs.getString("customerId"));
                Order order = new Order(rs.getString("orderID"), customer);
                Grocery item = new Grocery(rs.getString("itemName"), rs.getDouble("itemPrice"), rs.getString("itemExpiration"));
                order.addItem(item);
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
}
