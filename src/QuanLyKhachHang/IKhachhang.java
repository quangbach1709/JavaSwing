package QuanLyKhachHang;

import java.sql.Connection;

public interface IKhachhang {
    Connection getCon();

    Khachhang getbySTK(int stk);

    void undateKH(Khachhang kh);
}
