package PTIT.BASIC002_SuDungScannerVietChuoiChoTruoc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t!=0){
            String s = sc.nextLine();
            System.out.println(s);
            t--;
        }
        sc.close();
    }
}
