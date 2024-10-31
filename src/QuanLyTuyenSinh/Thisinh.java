package QuanLyTuyenSinh;

public class Thisinh {
    private int soBD;
    private String hoTen;
    private String GT;
    private String nganhH;
    private float tongD;

    public Thisinh() {

    }

    public Thisinh(int soBD, String hoTen, String GT, String nganhH, float tongD) {
        this.soBD = soBD;
        this.hoTen = hoTen;
        this.GT = GT;
        this.nganhH = nganhH;
        this.tongD = tongD;
    }

    public int getSoBD() {
        return soBD;
    }

    public void setSoBD(int soBD) {
        this.soBD = soBD;
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

    public String getNganhH() {
        return nganhH;
    }

    public void setNganhH(String nganhH) {
        this.nganhH = nganhH;
    }

    public float getTongD() {
        return tongD;
    }

    public void setTongD(float tongD) {
        this.tongD = tongD;
    }

    public String Hocbong() {
        if (this.tongD >= 29) {
            return "HB";
        } else {
            return null;
        }
    }
}
