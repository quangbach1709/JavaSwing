package QuanLyTuyenSinh;

import QuanLyKhachHang.GUI_undateKH;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class GUI_insertTS extends JFrame {
    private JTextField txtSoBD, txtHoTen, txtTongD;
    private JButton btnInsert;
    private JComboBox<String> comboBoxNganhH;
    private JTable tableTS;
    private JRadioButton radioButtonNam, radioButtonNu;

    public GUI_insertTS() {

        setTitle("Quản Lý Thông Tin Tuyển Sinh");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lbMaTS = new JLabel("So BD");
        lbMaTS.setBounds(20, 20, 100, 30);
        add(lbMaTS);
        txtSoBD = new JTextField();
        txtSoBD.setBounds(120, 20, 100, 30);
        add(txtSoBD);

        JLabel lbHoTen = new JLabel("Ho Ten");
        lbHoTen.setBounds(20, 60, 100, 30);
        add(lbHoTen);
        txtHoTen = new JTextField();
        txtHoTen.setBounds(120, 60, 200, 30);
        add(txtHoTen);

        JLabel lbGT = new JLabel("GT");
        lbGT.setBounds(20, 100, 100, 30);
        add(lbGT);

        radioButtonNam = new JRadioButton("Nam");
        radioButtonNam.setBounds(120, 100, 100, 30);
        radioButtonNam.setSelected(true);
        add(radioButtonNam);
        radioButtonNu = new JRadioButton("Nu");
        radioButtonNu.setBounds(220, 100, 100, 30);
        add(radioButtonNu);

        JLabel lbNganhH = new JLabel("Nganh Hoc");
        lbNganhH.setBounds(20, 140, 100, 30);
        add(lbNganhH);
        String[] intems = {"Tri Tue Nhan Tao", "Co Khi", "Cong Trinh Thuy"};
        comboBoxNganhH = new JComboBox<>(intems);
        comboBoxNganhH.setBounds(120, 140, 200, 30);
        add(comboBoxNganhH);


        JLabel lbTongD = new JLabel("Tong D");
        lbTongD.setBounds(20, 180, 100, 30);
        add(lbTongD);
        txtTongD = new JTextField();
        txtTongD.setBounds(120, 180, 100, 30);
        add(txtTongD);

        JLabel lbTableTS = new JLabel("Table Thong Tin Tuyen Sinh");
        DefaultTableModel model = new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String[]{"So BD", "Ho Ten", "GT", "Nganh Hoc", "TongD"}
        );

        tableTS = new JTable(model);
        tableTS.setBounds(20, 220, 500, 300);
        add(tableTS);

        btnInsert = new JButton("Insert");
        btnInsert.setBounds(240, 180, 100, 30);
        add(btnInsert);

        btnInsert.addActionListener(event -> {
            XLTS xlts = new XLTS();
            Thisinh thisinh = new Thisinh();
            thisinh.setSoBD(Integer.parseInt(txtSoBD.getText()));
            thisinh.setHoTen(txtHoTen.getText());
            thisinh.setGT(radioButtonNam.isSelected() ? "Nam" : "Nu");
            thisinh.setNganhH(comboBoxNganhH.getSelectedItem().toString());
            thisinh.setTongD(Float.parseFloat(txtTongD.getText()));
            xlts.insertTS(thisinh);
            JOptionPane.showMessageDialog(this, "Insert Thanh Cong");
            loadDataTable();
        });
        loadDataTable();
        setVisible(true);
    }

    public void loadDataTable() {
        XLTS xlts = new XLTS();
        List<Thisinh> list = xlts.getTS();
        DefaultTableModel model = (DefaultTableModel) tableTS.getModel();
        model.setRowCount(0);
        for (Thisinh ts : list) {
            model.addRow(new Object[]{
                    ts.getSoBD(), ts.getHoTen(), ts.getGT(), ts.getNganhH(), ts.getTongD()
            });
        }

    }

}
