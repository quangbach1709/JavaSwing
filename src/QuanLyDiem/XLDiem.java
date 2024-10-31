package QuanLyDiem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class XLDiem {
    private Connection cn;

    public Connection getConnection() {
        try {
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javatest", "root", "root");
            return cn;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Hocvien> getHV() {
        String sql = "SELECT * FROM tbHocvien";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Hocvien> list = new ArrayList<>();
            while (rs.next()) {
                Hocvien hocvien = new Hocvien(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getFloat(4)
                );
                list.add(hocvien);
            }
            return list;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void insertHV(Hocvien hocvien) {
        try {
            String sql = "INSERT INTO tbHocvien (MaHV,Hoten, Lop, Diem) VALUES (?,?,?,?)";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setInt(1, hocvien.getMaHV());
            ps.setString(2, hocvien.getHoTen());
            ps.setString(3, hocvien.getLop());
            ps.setFloat(4, hocvien.getDiem());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
