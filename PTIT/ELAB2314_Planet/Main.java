package PTIT.ELAB2314_Planet;

import java.util.Scanner;

public class Main {
    public static void main(String[] Nguyen_Di_Dan) {
        Scanner sc = new Scanner(System.in);
        try{
            while (true) {
                String name = sc.nextLine();
                HanhTinh hanhTinh = new HanhTinh(Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()));
                double khoiluongTraiDat = Double.parseDouble(sc.nextLine());
                System.out.printf("Your weight on %s is %.2f\n", name, hanhTinh.khoiLuongBeMat(khoiluongTraiDat));
            }
        }catch (Exception e) {
            return;
        }

    }

}

class HanhTinh {
    private double khoiluong;
    private double banKinh;
    public final double G = 6.67300e-11;
    public final double sGE = (5.976e24 * G) / Math.pow(6.37814e6, 2);

    public HanhTinh(double khoiluong, double banKinh) {
        this.khoiluong = khoiluong;
        this.banKinh = banKinh;
    }

    public double trongLucBeMat() {
        return (khoiluong * G) / Math.pow(banKinh, 2);
    }

    public double khoiLuongBeMat(double khoiluongTraiDat) {
        return  (trongLucBeMat()/sGE) * khoiluongTraiDat;
    }

}
