package PTIT.STRING003_KiemTraChuoiCoBangChuoiKhacHayKhong;

import java.util.Scanner;

public class Main {
    public static void main(String[] $) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());
        while (test-- > 0) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            System.out.println(s1.equalsIgnoreCase(s2));
        }
    }
}