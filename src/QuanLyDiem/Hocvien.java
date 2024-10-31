package QuanLyDiem;

public class Hocvien {
    private int maHV;
    private String hoTen;
    private String lop;
    private Float diem;

    public Hocvien() {

    }

    public Hocvien(int maHV, String hoTen, String lop, Float diem) {
        this.maHV = maHV;
        this.hoTen = hoTen;
        this.lop = lop;
        this.diem = diem;
    }

    public int getMaHV() {
        return maHV;
    }

    public void setMaHV(int maHV) {
        this.maHV = maHV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public Float getDiem() {
        return diem;
    }

    public void setDiem(Float diem) {
        this.diem = diem;
    }

    public String Ketqua() {
        if (this.diem > 25) {
            return "Dat";
        }
        return null;
    }
}
