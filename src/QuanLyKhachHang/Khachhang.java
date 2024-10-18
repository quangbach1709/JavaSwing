package QuanLyKhachHang;

public class Khachhang {
    private int soTK;
    private String hoTen;
    private String GT;
    private String diaChi;
    private float soDu;

    public Khachhang() {

    }

    public Khachhang(int soTK, String hoTen, String GT, String diaChi, float soDu) {
        this.soTK = soTK;
        this.hoTen = hoTen;
        this.GT = GT;
        this.diaChi = diaChi;
        this.soDu = soDu;
    }

    public int getSoTK() {
        return soTK;
    }

    public void setSoTK(int soTK) {
        this.soTK = soTK;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGT() {
        return GT;
    }

    public void setGT(String GT) {
        this.GT = GT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public float getSoDu() {
        return soDu;
    }

    public void setSoDu(float soDu) {
        this.soDu = soDu;
    }
}
