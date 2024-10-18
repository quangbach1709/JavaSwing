package QuanLyCanBo;

import javax.swing.*;

public class Gui extends JFrame {
    private JTextField txtMaNV, txtHoTen, txtDiachi, txtLuong;
    private JButton btnFind, btnUpdate, btnInsert, btnDelete;

    public Gui() {
        setTitle("Bang Nhan Vien");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lbMaNV = new JLabel("Ma NV");
        lbMaNV.setBounds(20, 20, 100, 30);
        add(lbMaNV);

        txtMaNV = new JTextField();
        txtMaNV.setBounds(120, 20, 200, 30);
        add(txtMaNV);

        JLabel lbHoTen = new JLabel("Ho Ten");
        lbHoTen.setBounds(20, 60, 100, 30);
        add(lbHoTen);

        txtHoTen = new JTextField();
        txtHoTen.setBounds(120, 60, 200, 30);
        add(txtHoTen);

        JLabel lbDiaChi = new JLabel("Dia Chi");
        lbDiaChi.setBounds(20, 100, 100, 30);
        add(lbDiaChi);

        txtDiachi = new JTextField();
        txtDiachi.setBounds(120, 100, 200, 30);
        add(txtDiachi);

        JLabel lbLuong = new JLabel("Luong");
        lbLuong.setBounds(20, 140, 100, 30);
        add(lbLuong);

        txtLuong = new JTextField();
        txtLuong.setBounds(120, 140, 200, 30);
        add(txtLuong);

        btnFind = new JButton("Find");
        btnFind.setBounds(120, 180, 100, 30);
        add(btnFind);

        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(220, 180, 100, 30);
        add(btnUpdate);

        btnInsert = new JButton("Insert");
        btnInsert.setBounds(120, 220, 100, 30);
        add(btnInsert);

        btnDelete = new JButton("Delete");
        btnDelete.setBounds(220, 220, 100, 30);
        add(btnDelete);
        setVisible(true);
    }

}
