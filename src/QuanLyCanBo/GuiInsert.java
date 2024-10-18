package QuanLyCanBo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class GuiInsert extends JFrame {

    private JTextField txtSoTk, txtHoTen, txtGT, txtDiaChi, txtLuong;
    private JButton btnXem, btnAdd;
    private JTable table;

    public GuiInsert() {
        setTitle("Quan Ly Can Bo");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lbSoTk = new JLabel("SoTk");
        lbSoTk.setBounds(20, 20, 100, 30);
        add(lbSoTk);

        txtSoTk = new JTextField();
        txtSoTk.setBounds(100, 20, 100, 30);
        add(txtSoTk);

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

        JLabel lbDiaChi = new JLabel("DiaChi");
        lbDiaChi.setBounds(20, 140, 100, 30);
        add(lbDiaChi);

        txtDiaChi = new JTextField();
        txtDiaChi.setBounds(100, 140, 100, 30);
        add(txtDiaChi);

        JLabel lbLuong = new JLabel("Luong");
        lbLuong.setBounds(20, 180, 100, 30);
        add(lbLuong);

        txtLuong = new JTextField();
        txtLuong.setBounds(100, 180, 100, 30);
        add(txtLuong);

        //them cot vao table SoTk, HoTen, GT, DiaChi, Luong
        DefaultTableModel model = new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String[]{
                        "SoTk", "HoTen", "GT", "DiaChi", "Luong"
                }
        );
        table = new JTable(model);
        table.setBounds(20, 260, 500, 300);
        add(table);

        //ham load du lieu
        btnXem = new JButton("Xem");
        btnXem.setBounds(20, 220, 100, 30);
        add(btnXem);

        //ham them du lieu
        btnAdd = new JButton("Add");
        btnAdd.setBounds(120, 220, 100, 30);
        add(btnAdd);

        btnXem.addActionListener(e -> loadData());
        btnAdd.addActionListener(e -> {
            Canbo cb = new Canbo(
                    Integer.parseInt(txtSoTk.getText()),
                    txtHoTen.getText(),
                    txtGT.getText(),
                    txtDiaChi.getText(),
                    Float.parseFloat(txtLuong.getText())
            );
            QLCB qlcb = new QLCB();
            qlcb.insertCB(cb);
            loadData();
        });


        setVisible(true);
    }

    public void loadData() {
        QLCB qlcb = new QLCB();
        List<Canbo> list = qlcb.getCB();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for (Canbo cb : list) {
            model.addRow(new Object[]{
                    cb.getSoTK(), cb.getHoTen(), cb.getGT(), cb.getDiaChi(), cb.getLuong()
            });
        }
    }

}
