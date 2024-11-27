package QuanLySinhVien;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;

public class XuLySinhVien implements IQuanLySV {
    private Connection connection;

    @Override
    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "root");
            return connection;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addStudent(Student student) {
        try {
            String sql = "INSERT INTO student(maSv, hoTen, age, gt, address, gpa, lop) VALUES(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, student.getMaSv());
            preparedStatement.setString(2, student.getHoTen());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setString(4, student.getGt());
            preparedStatement.setString(5, student.getAddress());
            preparedStatement.setFloat(6, student.getGpa());
            preparedStatement.setString(7, student.getLop());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateStudent(Student student) {
        try {
            String sql = "UPDATE student SET hoTen = ?, age = ?, gt = ?, address = ?, gpa = ?, lop = ? WHERE maSv = ?";
            PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setString(1, student.getHoTen());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setString(3, student.getGt());
            preparedStatement.setString(4, student.getAddress());
            preparedStatement.setFloat(5, student.getGpa());
            preparedStatement.setString(6, student.getLop());
            preparedStatement.setInt(7, student.getMaSv());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteStudent(int maSv) {
        try {
            String sql = "DELETE FROM student WHERE maSv = ?";
            PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, maSv);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> showAllStudent() {
        List<Student> students = new ArrayList<>();
        try {
            String query = "SELECT * FROM students";
            PreparedStatement stmt = getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Student student = new Student(
                        rs.getInt("ma_sv"),
                        rs.getString("ho_ten"),
                        rs.getInt("tuoi"),
                        rs.getString("gioi_tinh"),
                        rs.getString("dia_chi"),
                        rs.getFloat("diem_tb"),
                        rs.getString("lop")
                );
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public List<Student> showStudentByClass(String lop) {
        try {
            List<Student> students = new ArrayList<>();
            String sql = "SELECT * FROM student WHERE lop = ?";
            PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setString(1, lop);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int maSv = resultSet.getInt("maSv");
                String hoTen = resultSet.getString("hoTen");
                int age = resultSet.getInt("age");
                String gt = resultSet.getString("gt");
                String address = resultSet.getString("address");
                float gpa = resultSet.getFloat("gpa");
                Student student = new Student(maSv, hoTen, age, gt, address, gpa, lop);
                students.add(student);
            }
            return students;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> showStudentByMaSv(int maSv) {
        try {
            List<Student> students = new ArrayList<>();
            String sql = "SELECT * FROM student WHERE maSv = ?";
            PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, maSv);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String hoTen = resultSet.getString("hoTen");
                int age = resultSet.getInt("age");
                String gt = resultSet.getString("gt");
                String address = resultSet.getString("address");
                float gpa = resultSet.getFloat("gpa");
                String lop = resultSet.getString("lop");
                Student student = new Student(maSv, hoTen, age, gt, address, gpa, lop);
                students.add(student);
            }
            return students;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
