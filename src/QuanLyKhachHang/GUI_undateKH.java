package QuanLyKhachHang;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GUI_undateKH extends JFrame {
    private JTextField txtSoTK, txtHoTen, txtGT, txtSoDu;
    private JComboBox<String> comboBoxDiaChi;
    private JTable table;
    private JButton btnSearch, btnUpdate;
    private XLKH xlkh;


    public GUI_undateKH() {
        xlkh = new XLKH();
        setTitle("Quan Ly Khach Hang");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lbSoTK = new JLabel("SoTK");
        lbSoTK.setBounds(20, 20, 100, 30);
        add(lbSoTK);

        txtSoTK = new JTextField();
        txtSoTK.setBounds(100, 20, 100, 30);
        add(txtSoTK);

        JLabel lbHoTen = new JLabel("HoTen");
        lbHoTen.setBounds(20, 60, 100, 30);
        add(lbHoTen);

        txtHoTen = new JTextField();
        txtHoTen.setBounds(100, 60, 100, 30);
        add(txtHoTen);

        JLabel lbGT = new JLabel("GT");
        lbGT.setBounds(20, 100, 100, 30);
        add(lbGT);

        txtGT = new JTextField();
        txtGT.setBounds(100, 100, 100, 30);
        add(txtGT);

        String[] item = {"Ha Noi", "Can Tho", "Da Nang"};
        comboBoxDiaChi = new JComboBox<>(item);
        comboBoxDiaChi.setBounds(100, 140, 100, 30);
        add(comboBoxDiaChi);

        JLabel lbSoDu = new JLabel("SoDu");
        lbSoDu.setBounds(20, 180, 100, 30);
        add(lbSoDu);

        txtSoDu = new JTextField();
        txtSoDu.setBounds(100, 180, 100, 30);
        add(txtSoDu);

        btnSearch = new JButton("Search");
        btnSearch.setBounds(100, 220, 100, 30);
        add(btnSearch);

        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(200, 220, 100, 30);
        add(btnUpdate);

        //them cot vao table SoTK, HoTen, GT, DiaChi, SoDu
        DefaultTableModel model = new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String[]{
                        "SoTK", "HoTen", "GT", "DiaChi", "SoDu"
                }
        );
        table = new JTable(model);
        table.setBounds(20, 260, 500, 300);
        add(table);

        btnSearch.addActionListener(e -> {
            int soTK = Integer.parseInt(txtSoTK.getText());
            Khachhang khachhang = xlkh.getbySTK(soTK);
            txtHoTen.setText(khachhang.getHoTen());
            txtGT.setText(khachhang.getGT());
            comboBoxDiaChi.setSelectedItem(khachhang.getDiaChi());
            txtSoDu.setText(String.valueOf(khachhang.getSoDu()));
            loadDatabySoTK(soTK);

        });

        btnUpdate.addActionListener(e -> {
            Khachhang kh = new Khachhang();
            kh.setSoTK(Integer.parseInt(txtSoTK.getText()));
            kh.setHoTen(txtHoTen.getText());
            kh.setGT(txtGT.getText());
            kh.setDiaChi(comboBoxDiaChi.getSelectedItem().toString());
            kh.setSoDu(Float.parseFloat(txtSoDu.getText()));
            xlkh.undateKH(kh);
            loadDatabySoTK(kh.getSoTK());
        });

        setVisible(true);

    }

    public void loadDatabySoTK(int soTK) {
        XLKH xlkh = new XLKH();
        Khachhang kh = xlkh.getbySTK(soTK);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        model.addRow(new Object[]{
                kh.getSoTK(), kh.getHoTen(), kh.getGT(), kh.getDiaChi(), kh.getSoDu()

        });


    }
}
