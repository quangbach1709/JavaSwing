package QuanLyLuong;

import javax.swing.*;

public class GUI_updateNV extends JFrame {
    private JTextField txtMaNV, txtHoTen, txtLuong;
    private JButton btnUpdate, btnSearch;
    private JComboBox<String> comboBoxDiachi;

    public GUI_updateNV() {
        setTitle("Cập Nhật Thông Tin Nhân Viên");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        JLabel lbMaNV = new JLabel("Mã NV");
        lbMaNV.setBounds(20, 20, 100, 30);
        add(lbMaNV);
        txtMaNV = new JTextField();
        txtMaNV.setBounds(120, 20, 200, 30);
        add(txtMaNV);
        JLabel lbHoTen = new JLabel("Họ Tên");
        lbHoTen.setBounds(20, 60, 100, 30);
        add(lbHoTen);
        txtHoTen = new JTextField();
        txtHoTen.setBounds(120, 60, 200, 30);
        add(txtHoTen);
        JLabel lbDiachi = new JLabel("Địa Chỉ");
        lbDiachi.setBounds(20, 100, 100, 30);
        add(lbDiachi);
        String[] item = {"Ha Noi", "Hai Phong", "Nam Dinh"};
        comboBoxDiachi = new JComboBox<String>(item);
        comboBoxDiachi.setBounds(120, 100, 200, 30);
        add(comboBoxDiachi);
        JLabel lbLuong = new JLabel("Lương");
        lbLuong.setBounds(20, 140, 100, 30);
        add(lbLuong);
        txtLuong = new JTextField();
        txtLuong.setBounds(120, 140, 200, 30);
        add(txtLuong);
        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(120, 180, 100, 30);
        add(btnUpdate);

        btnSearch = new JButton("Search");
        btnSearch.setBounds(220, 180, 100, 30);
        add(btnSearch);

        btnSearch.addActionListener(event -> {
            int maNV = Integer.parseInt(txtMaNV.getText());
            // Tìm và hiển thị thông tin nhân viên tương ứng với mã NV
            XLLuong xlLuong = new XLLuong();
            Nhanvien nv = xlLuong.getNVbyMa(maNV);
            txtHoTen.setText(nv.getHoTen());
            comboBoxDiachi.setSelectedItem(nv.getDiaChi());
            txtLuong.setText(String.valueOf(nv.getLuong()));


        });
        btnUpdate.addActionListener(event -> {
            XLLuong xlLuong = new XLLuong();
            int maNV = Integer.parseInt(txtMaNV.getText());
            String hoTen = txtHoTen.getText();
            String diaChi = (String) comboBoxDiachi.getSelectedItem();
            float luong = Float.parseFloat(txtLuong.getText());
            Nhanvien nv = new Nhanvien(maNV, hoTen, diaChi, luong);
            xlLuong.updateNV(nv);
            JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
        });
        setVisible(true);
    }
}
