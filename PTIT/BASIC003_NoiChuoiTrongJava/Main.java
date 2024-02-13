package PTIT.BASIC003_NoiChuoiTrongJava;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t>0){
            String s = sc.nextLine();
            System.out.println("Hi " + s);
            t--;
        }
    }
}
