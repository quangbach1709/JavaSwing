package QuanLyCanBo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class QLCB implements ICanbo {
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
    public Canbo insertCB(Canbo cb) {
        String sql = "INSERT INTO tbcanbo(SoTK, Hoten, GT, Diachi, Luong) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, cb.getSoTK());
            ps.setString(2, cb.getHoTen());
            ps.setString(3, cb.getGT());
            ps.setString(4, cb.getDiaChi());
            ps.setFloat(5, cb.getLuong());
            ps.executeUpdate();
            System.out.println("Them thanh cong");
            return cb;
        } catch (Exception e) {
            System.out.println("Them that bai");
            throw new RuntimeException(e);
        }
    }

    //lay toan bo du lieu trong bảng
    public List<Canbo> getCB() {
        String sql = "SELECT * FROM tbcanbo";
        List<Canbo> list = new LinkedList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Canbo cb = new Canbo(
                        rs.getInt("SoTK"),
                        rs.getString("Hoten"),
                        rs.getString("GT"),
                        rs.getString("Diachi"),
                        rs.getFloat("Luong")
                );
                list.add(cb);
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
