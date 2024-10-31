package QuanLyLuong;

public class Nhanvien extends Person {
    private String diaChi;
    private float luong;

    public Nhanvien() {
    }

    public Nhanvien(String diaChi, float luong) {
        this.diaChi = diaChi;
        this.luong = luong;
    }

    public Nhanvien(int maNV, String hoTen, String diaChi, float luong) {
        super(maNV, hoTen);
        this.diaChi = diaChi;
        this.luong = luong;
    }

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
