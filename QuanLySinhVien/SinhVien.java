package QuanLySinhVien;

public class SinhVien implements Comparable<SinhVien> {
    private String hoTen;
    private  String maSv;
    private float diemToan;
    private float diemLy;
    private float diemHoa;
    public SinhVien(String hoTen, String maSv, float diemToan, float diemLy, float diemHoa){
        this.hoTen = hoTen;
        this.maSv = maSv;
        this.diemToan = diemToan;
        this.diemLy = diemLy;
        this.diemHoa = diemHoa;
    }

    public String getHoTen() {
        return hoTen;
    }
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    public String getMaSv() {
        return maSv;
    }
    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }
    public float getDiemToan() {
        return diemToan;
    }
    public void setDiemToan(float diemToan) {
        this.diemToan = diemToan;
    }
    public float getDiemLy() {
        return diemLy;
    }
    public void setDiemLy(float diemLy) {
        this.diemLy = diemLy;
    }
    public float getDiemHoa() {
        return diemHoa;
    }
    public void setDiemHoa(float diemHoa) {
        this.diemHoa = diemHoa;
    }
    public float diemTb() {
        return (this.diemToan + this.diemLy + this.diemHoa) / 3;
    }
    @Override
    public int compareTo(SinhVien x){
        return Float.compare(this.diemTb(), x.diemTb());
    }
}
