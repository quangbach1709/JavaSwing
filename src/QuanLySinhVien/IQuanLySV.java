package QuanLySinhVien;

import java.sql.Connection;
import java.util.List;

public interface IQuanLySV {
    Connection getConnection();

    void addStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(int maSv);

    List<Student> showAllStudent();

    List<Student> showStudentByClass(String lop);

    List<Student> showStudentByMaSv(int maSv);
}
