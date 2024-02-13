package PTIT.BASIC005_TinhTong5ChuSo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t!=0){
            long [] arr = new long[5];
            long sum = 0;
            for (long i:arr){
                sum+=sc.nextInt();
            }
            System.out.println(sum);
            t--;
        }
    }
}
