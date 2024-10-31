package QuanLySach;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class XLSach implements ISach {
    private Connection cn;

    @Override
    public Connection getConnection() {
        try {
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javatest", "root", "root");
            return cn;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Sach> getSA() {
        String sql = "SELECT * FROM tbSach";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Sach> list = new LinkedList<>();
            while (rs.next()) {
                Sach sach = new Sach(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getFloat(5)
                );
                list.add(sach);
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Sach> getSAbyNXBGB(String nhaXB, float giaB) {
        String sql = "SELECT * FROM tbSach WHERE NhaXB = ? AND GiaB = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, nhaXB);
            ps.setFloat(2, giaB);
            ResultSet rs = ps.executeQuery();
            List<Sach> list = new LinkedList<>();
            while (rs.next()) {
                Sach s = new Sach(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getFloat(5)
                );
                list.add(s);
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
