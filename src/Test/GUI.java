package Test;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class GUI extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField txtOrderID, txtCustomerName, txtCustomerId, txtItemName, txtItemPrice, txtItemExpiration;
    private JButton btnUpdate;

    public GUI() {
        setTitle("Order Management");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Table
        tableModel = new DefaultTableModel(new String[]{"Order ID", "Customer Name", "Item Name", "Price", "Expiration Date"}, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Form
        JPanel formPanel = new JPanel(new GridLayout(7, 2));
        formPanel.add(new JLabel("Order ID:"));
        txtOrderID = new JTextField();
        formPanel.add(txtOrderID);

        formPanel.add(new JLabel("Customer Name:"));
        txtCustomerName = new JTextField();
        formPanel.add(txtCustomerName);

        formPanel.add(new JLabel("Customer ID:"));
        txtCustomerId = new JTextField();
        formPanel.add(txtCustomerId);

        formPanel.add(new JLabel("Item Name:"));
        txtItemName = new JTextField();
        formPanel.add(txtItemName);

        formPanel.add(new JLabel("Item Price:"));
        txtItemPrice = new JTextField();
        formPanel.add(txtItemPrice);

        formPanel.add(new JLabel("Item Expiration:"));
        txtItemExpiration = new JTextField();
        formPanel.add(txtItemExpiration);

        btnUpdate = new JButton("Update Order");
        formPanel.add(btnUpdate);

        add(formPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }
}