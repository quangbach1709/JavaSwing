package QuanLyKhachHang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class XLKH implements IKhachhang {
    private Connection cn;

    @Override
    public Connection getCon() {
        try {
            String url = "jdbc:mysql://localhost:3306/javatest";
            cn = DriverManager.getConnection(url, "root", "root");
            return cn;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Khachhang getbySTK(int SoTK) {
        String sql = "select * from tbkh where SoTK = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, SoTK);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Khachhang kh = new Khachhang(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getFloat(5)
                );
                return kh;
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // XLKH.java
    @Override
    public void undateKH(Khachhang kh) {
        String sql = "UPDATE tbkh SET Hoten = ?, GT = ?, Diachi = ?, Sodu = ? WHERE SoTK = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, kh.getHoTen());
            ps.setString(2, kh.getGT());
            ps.setString(3, kh.getDiaChi());
            ps.setFloat(4, kh.getSoDu());
            ps.setInt(5, kh.getSoTK());
            ps.executeUpdate(); // Use executeUpdate() for update statements
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
