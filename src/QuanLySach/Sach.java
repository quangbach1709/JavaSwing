package QuanLySach;

public class Sach {
    private int maS;
    private String tenS;
    private String nhaXB;
    private int namXB;
    private float giaB;

    public Sach() {
    }

    public Sach(int maS, String tenS, String nhaXB, int namXB, float giaB) {
        this.maS = maS;
        this.tenS = tenS;
        this.nhaXB = nhaXB;
        this.namXB = namXB;
        this.giaB = giaB;
    }

    public int getMaS() {
        return maS;
    }

    public void setMaS(int maS) {
        this.maS = maS;
    }

    public String getTenS() {
        return tenS;
    }

    public void setTenS(String tenS) {
        this.tenS = tenS;
    }

    public String getNhaXB() {
        return nhaXB;
    }

    public void setNhaXB(String nhaXB) {
        this.nhaXB = nhaXB;
    }

    public int getNamXB() {
        return namXB;
    }

    public void setNamXB(int namXB) {
        this.namXB = namXB;
    }

    public float getGiaB() {
        return giaB;
    }

    public void setGiaB(float giaB) {
        this.giaB = giaB;
    }

    public void Khuyenmai() {
        this.giaB = this.giaB - ((this.giaB / 100) * 25);
    }
}
