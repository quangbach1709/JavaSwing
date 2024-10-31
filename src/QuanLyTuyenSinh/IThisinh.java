package QuanLyTuyenSinh;

import java.sql.Connection;
import java.util.List;

public interface IThisinh {
    Connection getConnection();

    List<Thisinh> getTS();

    void insertTS(Thisinh TS);
}
