package QuanLyLuong;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class XLLuong {
    private Connection cn;

    public Connection getConnection() {
        try {
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javatest", "root", "root");
            return cn;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public Nhanvien getNVbyMa(int maNV) {
        try {

            String sql = "SELECT * FROM tbNhanvien WHERE MaNV =?";
            PreparedStatement ps = getConnection().prepareStatement(sql);

            ps.setInt(1, maNV);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Nhanvien nv = new Nhanvien(
                        rs.getInt("MaNV"),
                        rs.getString("Hoten"),
                        rs.getString("Diachi"),
                        rs.getFloat("Luong")
                );
                return nv;
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void updateNV(Nhanvien nv) {
        String sql = "UPDATE tbNhanvien SET Hoten =?, Diachi =?, Luong =? WHERE MaNV =?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, nv.getHoTen());
            ps.setString(2, nv.getDiaChi());
            ps.setFloat(3, nv.getLuong());
            ps.setInt(4, nv.getMaNV());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
