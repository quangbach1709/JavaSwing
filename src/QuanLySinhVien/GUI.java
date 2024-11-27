package QuanLySinhVien;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class GUI extends JFrame {
    private JTextField txtMaSv, txtHoTen, txtAge, txtAddress, txtGpa;
    private JComboBox<String> cbLop, cbGt;
    private JButton btnAdd, btnUpdate, btnDelete, btnShowByClass, btnShowByMaSv;
    private JTable table;

    public GUI() {
        setTitle("Quản lý sinh viên");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        JLabel lblMaSv = new JLabel("Mã sinh viên");
        lblMaSv.setBounds(50, 50, 100, 30);
        add(lblMaSv);

        txtMaSv = new JTextField();
        txtMaSv.setBounds(150, 50, 200, 30);
        add(txtMaSv);

        JLabel lblHoTen = new JLabel("Họ tên");
        lblHoTen.setBounds(50, 100, 100, 30);
        add(lblHoTen);

        txtHoTen = new JTextField();
        txtHoTen.setBounds(150, 100, 200, 30);
        add(txtHoTen);

        JLabel lblAge = new JLabel("Tuổi");
        lblAge.setBounds(50, 150, 100, 30);
        add(lblAge);

        txtAge = new JTextField();
        txtAge.setBounds(150, 150, 200, 30);
        add(txtAge);

        JLabel lblGt = new JLabel("Giới tính");
        lblGt.setBounds(50, 200, 100, 30);
        add(lblGt);

        String[] gt = {"Nam", "Nữ"};
        cbGt = new JComboBox<>(gt);
        cbGt.setBounds(150, 200, 200, 30);
        add(cbGt);

        JLabel lblAddress = new JLabel("Địa chỉ");
        lblAddress.setBounds(50, 250, 100, 30);
        add(lblAddress);

        txtAddress = new JTextField();
        txtAddress.setBounds(150, 250, 200, 30);
        add(txtAddress);

        JLabel lblGpa = new JLabel("Điểm TB");
        lblGpa.setBounds(50, 300, 100, 30);
        add(lblGpa);

        txtGpa = new JTextField();
        txtGpa.setBounds(150, 300, 200, 30);
        add(txtGpa);

        JLabel lblLop = new JLabel("Lớp");
        lblLop.setBounds(50, 350, 100, 30);
        add(lblLop);

        String[] lop = {"KTPM", "CNTT", "ATTT"};
        cbLop = new JComboBox<>(lop);
        cbLop.setBounds(150, 350, 200, 30);
        add(cbLop);

        btnAdd = new JButton("Thêm");
        btnAdd.setBounds(50, 400, 100, 30);
        add(btnAdd);

        btnUpdate = new JButton("Sửa");
        btnUpdate.setBounds(200, 400, 100, 30);
        add(btnUpdate);

        btnDelete = new JButton("Xóa");
        btnDelete.setBounds(350, 400, 100, 30);
        add(btnDelete);

        btnShowByClass = new JButton("Search by lớp");
        btnShowByClass.setBounds(500, 400, 150, 30);
        add(btnShowByClass);

        btnShowByMaSv = new JButton("Search by mã sv");
        btnShowByMaSv.setBounds(650, 400, 150, 30);
        add(btnShowByMaSv);

        DefaultTableModel model = new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                }, new String[]{"Mã SV", "Họ tên", "Tuổi", "Giới tính", "Địa chỉ", "Điểm TB", "Lớp"}
        );

        table = new JTable(model);
        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setBounds(50, 450, 750, 100);
        add(jScrollPane);

        btnAdd.addActionListener(e -> {

            Student student = new Student(
                    Integer.parseInt(txtMaSv.getText()),
                    txtHoTen.getText(),
                    Integer.parseInt(txtAge.getText()),
                    cbGt.getSelectedItem().toString(),
                    txtAddress.getText(),
                    Float.parseFloat(txtGpa.getText()),
                    cbLop.getSelectedItem().toString()
            );
            IQuanLySV qlsv = new XuLySinhVien();
            qlsv.addStudent(student);
            LoadData();
        });

        btnUpdate.addActionListener(e -> {

            IQuanLySV qlsv = new XuLySinhVien();
            Student student = new Student(
                    Integer.parseInt(txtMaSv.getText()),
                    txtHoTen.getText(),
                    Integer.parseInt(txtAge.getText()),
                    cbGt.getSelectedItem().toString(),
                    txtAddress.getText(),
                    Float.parseFloat(txtGpa.getText()),
                    cbLop.getSelectedItem().toString()
            );
            qlsv.updateStudent(student);
            LoadData();

        });

        btnDelete.addActionListener(e -> {
            int maSv = Integer.parseInt(txtMaSv.getText());
            IQuanLySV qlsv = new XuLySinhVien();
            qlsv.deleteStudent(maSv);
            model.addRow(new Object[]{maSv});
            LoadData();
        });

        btnShowByClass.addActionListener(e -> {
            String lop1 = cbLop.getSelectedItem().toString();
            IQuanLySV qlsv = new XuLySinhVien();
            for (Student student : qlsv.showStudentByClass(lop1)) {
                model.addRow(new Object[]{student.getMaSv(), student.getHoTen(), student.getAge(), student.getGt(), student.getAddress(), student.getGpa(), student.getLop()});
            }
        });

        btnShowByMaSv.addActionListener(e -> {
            int maSv = Integer.parseInt(txtMaSv.getText());
            IQuanLySV qlsv = new XuLySinhVien();
            for (Student student : qlsv.showStudentByMaSv(maSv)) {
                model.addRow(new Object[]{student.getMaSv(), student.getHoTen(), student.getAge(), student.getGt(), student.getAddress(), student.getGpa(), student.getLop()});
            }
        });

        LoadData();
        setVisible(true);

    }

    public void LoadData() {
        IQuanLySV qlsv = new XuLySinhVien();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        List<Student> students = qlsv.showAllStudent();
        model.setRowCount(0);
        for (Student student : students) {
            model.addRow(new Object[]{student.getMaSv(), student.getHoTen(), student.getAge(), student.getGt(), student.getAddress(), student.getGpa(), student.getLop()});
        }
    }

}
