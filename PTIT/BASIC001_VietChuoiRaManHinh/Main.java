package PTIT.BASIC001_VietChuoiRaManHinh;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0){
            System.out.println(sc.nextLine());
            t--;
        }
        sc.close();
    }
}
