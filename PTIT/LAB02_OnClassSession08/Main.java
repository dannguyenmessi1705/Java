package PTIT.LAB02_OnClassSession08;

import java.util.Scanner;

public class Main {
    public static void main(String[] $) {
        Scanner sc = new Scanner(System.in);
        while (true){
            try {
                String a = sc.nextLine();
                String b = sc.nextLine();
                String[] s = b.split("\"");
                System.out.println(a.equals(s[1]));
            } catch (Exception e) {
                break;
            }
        }
    }
}
