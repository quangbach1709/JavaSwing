package QuanLySach;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class GUI_findSA extends JFrame {
    private JTextField txtMaSach, txtTenSach, txtNamXB, txtGiaBan;
    private JComboBox<String> comboBoxNhaXB;
    private JButton btnSearch;
    private JTable tableSach;
    private DefaultTableModel model = new DefaultTableModel(
            new Object[][]{
                    {null, null, null, null, null},
                    {null, null, null, null, null}
            },
            new String[]{"Mã Sách", "Tên Sách", "Nhà XB", "Nam XB", "Giá Bán"}
    );

    public GUI_findSA() {
        setTitle("Tìm Kiếm Sách");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lbMaSach = new JLabel("Mã Sách:");
        lbMaSach.setBounds(20, 20, 100, 30);
        add(lbMaSach);
        txtMaSach = new JTextField();
        txtMaSach.setBounds(120, 20, 100, 30);
        add(txtMaSach);
        JLabel lbTenSach = new JLabel("Tên Sách:");
        lbTenSach.setBounds(20, 60, 100, 30);
        add(lbTenSach);
        txtTenSach = new JTextField();
        txtTenSach.setBounds(120, 60, 200, 30);
        add(txtTenSach);
        JLabel lbNhaXB = new JLabel("Nha xuat ban");
        lbNhaXB.setBounds(20, 100, 100, 30);
        add(lbNhaXB);
        String[] items = {"Kim Dong", "Thanh Nien", "Giao Duc"};
        comboBoxNhaXB = new JComboBox<String>(items);
        comboBoxNhaXB.setBounds(120, 100, 200, 30);
        add(comboBoxNhaXB);
        JLabel lbNamXB = new JLabel("Nam XB:");
        lbNamXB.setBounds(20, 140, 100, 30);
        add(lbNamXB);
        txtNamXB = new JTextField();
        txtNamXB.setBounds(120, 140, 100, 30);
        add(txtNamXB);
        JLabel lbGiaBan = new JLabel("Gia Bán:");
        lbGiaBan.setBounds(20, 180, 100, 30);
        add(lbGiaBan);
        txtGiaBan = new JTextField();
        txtGiaBan.setBounds(120, 180, 100, 30);
        add(txtGiaBan);
        btnSearch = new JButton("Search");
        btnSearch.setBounds(120, 220, 100, 30);
        add(btnSearch);
//        DefaultTableModel model = new DefaultTableModel(
//                new Object[][]{
//                        {null, null, null, null, null},
//                        {null, null, null, null, null}
//                },
//                new String[]{"Mã Sách", "Tên Sách", "Nhà XB", "Nam XB", "Giá Bán"}
//        );
        tableSach = new JTable(model);
//        tableSach.setBounds(20, 260, 500, 200);
//        add(tableSach);
        JScrollPane scrollPane = new JScrollPane(tableSach);
        scrollPane.setBounds(20, 260, 500, 200);
        add(scrollPane);
        btnSearch.addActionListener(e -> {

            XLSach xlSach = new XLSach();
            String nhaXB = comboBoxNhaXB.getSelectedItem().toString();
            Float giaB = Float.parseFloat(txtGiaBan.getText());
            List<Sach> saches = xlSach.getSAbyNXBGB(nhaXB, giaB);
            DefaultTableModel modelSach = (DefaultTableModel) tableSach.getModel();
            modelSach.setRowCount(0);
            for (Sach sa : saches) {
                model.addRow(new Object[]{
                        sa.getMaS(), sa.getTenS(), sa.getNhaXB(), sa.getNamXB(), sa.getGiaB()
                });
            }

        });
        loadData();
        setVisible(true);
    }

    public void loadData() {
        XLSach xlSach = new XLSach();
        List<Sach> list = xlSach.getSA();
//        DefaultTableModel model = (DefaultTableModel) tableSach.getModel();
        model.setRowCount(0);
        for (Sach sa : list) {
            model.addRow(new Object[]{
                    sa.getMaS(), sa.getTenS(), sa.getNhaXB(), sa.getNamXB(), sa.getGiaB()
            });
        }
    }
}
