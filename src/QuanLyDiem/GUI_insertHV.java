package QuanLyDiem;

import QuanLyTuyenSinh.XLTS;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class GUI_insertHV extends JFrame {
    private JTextField txtMaHV, txtHoTen, txtDiem;
    private JComboBox<String> comboBoxLop;
    private JButton btnInsert;

    private JTable tableHV;

    public GUI_insertHV() {
        setTitle("Quản Lý Thông Tin Học Viên");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        JLabel lbMaHV = new JLabel("Mã HV");
        lbMaHV.setBounds(20, 20, 100, 30);
        add(lbMaHV);
        txtMaHV = new JTextField();
        txtMaHV.setBounds(120, 20, 100, 30);
        add(txtMaHV);
        JLabel lbHoTen = new JLabel("Họ Tên");
        lbHoTen.setBounds(20, 60, 100, 30);
        add(lbHoTen);
        txtHoTen = new JTextField();
        txtHoTen.setBounds(120, 60, 200, 30);
        add(txtHoTen);
        JLabel lbLop = new JLabel("Lop");
        lbLop.setBounds(20, 100, 100, 30);
        add(lbLop);
        String[] item = {"62TH1", "62PM1", "62PM2"};
        comboBoxLop = new JComboBox<String>(item);
        comboBoxLop.setBounds(120, 100, 200, 30);
        add(comboBoxLop);
        JLabel lbDiem = new JLabel("Điểm");
        lbDiem.setBounds(20, 140, 100, 30);
        add(lbDiem);
        txtDiem = new JTextField();
        txtDiem.setBounds(120, 140, 100, 30);
        add(txtDiem);

        DefaultTableModel model = new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{"Mã HV", "Họ Tên", "Lop", "Điểm"}
        );
        tableHV = new JTable(model);
        tableHV.setBounds(20, 200, 360, 100);
        add(tableHV);
        btnInsert = new JButton("Thêm");
        btnInsert.setBounds(220, 140, 100, 30);
        add(btnInsert);
        btnInsert.addActionListener(e -> {
            XLDiem xldiem = new XLDiem();
            Hocvien hocvien = new Hocvien(
                    Integer.parseInt(txtMaHV.getText()),
                    txtHoTen.getText(),
                    comboBoxLop.getSelectedItem().toString(),
                    Float.parseFloat(txtDiem.getText())
            );
            xldiem.insertHV(hocvien);
            loadData();
        });
        setVisible(true);
        loadData();
    }

    public void loadData() {
        XLDiem xldiem = new XLDiem();
        List<Hocvien> list = xldiem.getHV();
        DefaultTableModel model = (DefaultTableModel) tableHV.getModel();
        model.setRowCount(0);
        for (Hocvien hocvien : list) {
            model.addRow(new Object[]{
                    hocvien.getMaHV(), hocvien.getHoTen(), hocvien.getLop(), hocvien.getDiem()
            });
        }

    }
}
