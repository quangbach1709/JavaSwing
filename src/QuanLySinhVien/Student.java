package QuanLySinhVien;

public class Student {
    private int maSv;
    private String hoTen;
    private int age;
    private String gt;
    private String address;
    private float gpa;
    private String lop;

    public Student() {
    }


    public Student(int maSv, String hoTen, int age, String gt, String address, float gpa, String lop) {
        this.maSv = maSv;
        this.hoTen = hoTen;
        this.age = age;
        this.gt = gt;
        this.address = address;
        this.gpa = gpa;
        this.lop = lop;
    }

    public int getMaSv() {
        return maSv;
    }

    public void setMaSv(int maSv) {
        this.maSv = maSv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGt() {
        return gt;
    }

    public void setGt(String gt) {
        this.gt = gt;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }
}
