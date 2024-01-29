package exercise;

import java.util.ArrayList;
import java.util.Scanner;

public class E3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        long mul = 1L;
        for (int i=0; i<len; i++){
            mul*=sc.nextInt();
        }
        System.out.print(mul);
    }
}
