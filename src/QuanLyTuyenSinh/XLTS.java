package QuanLyTuyenSinh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class XLTS implements IThisinh {
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
    public List<Thisinh> getTS() {
        String sql = "select * from tbThisinh";
        // Implement logic to fetch and return a Thisinh object from the database
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Thisinh> listTS = new ArrayList<>();
            while (rs.next()) {
                Thisinh ts = new Thisinh(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getFloat(5)
                );
                listTS.add(ts);
            }
            return listTS;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insertTS(Thisinh TS) {
        String sql = "insert into tbThisinh (SoBD, Hoten, GT, NganhH,TongD) values (?,?,?,?,?)";
        // Implement logic to insert a new Thisinh object into the database
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            // Set values for the parameters
            ps.setInt(1, TS.getSoBD());
            ps.setString(2, TS.getHoTen());
            ps.setString(3, TS.getGT());
            ps.setString(4, TS.getNganhH());
            ps.setFloat(5, TS.getTongD());
            
            ps.executeUpdate(); // Use executeUpdate() for update statements

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
