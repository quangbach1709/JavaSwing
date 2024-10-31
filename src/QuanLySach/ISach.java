package QuanLySach;

import java.sql.Connection;
import java.util.List;

public interface ISach {
    Connection getConnection();

    List<Sach> getSA();

    List<Sach> getSAbyNXBGB(String nhaXB, float giaB);
}
