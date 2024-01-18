package QuanLySinhVien;

import java.util.*;

public class Main {
    public static void main(String[]args) {
        ArrayList<SinhVien> SV = new ArrayList<SinhVien>();
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Nhap so luong sinh vien: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++){
            System.out.print("Nhap ten sinh vien: ");
            String hoTen = sc.next();
            System.out.print("Nhap ma sinh vien: ");
            String maSv = sc.next();
            System.out.print("Nhap diem Toan sinh vien: ");
            float diemToan = sc.nextFloat();
            System.out.print("Nhap diem Ly sinh vien: ");
            float diemLy = sc.nextFloat();
            System.out.print("Nhap diem Hoa sinh vien: ");
            float diemHoa = sc.nextFloat();
            SinhVien sv = new SinhVien(hoTen, maSv, diemToan, diemLy, diemHoa);
            SV.add(sv);
        }
        Collections.sort(SV);
        for (SinhVien i:SV){
            System.out.println(i.diemTb());
        }
        sc.close();
    }
}
