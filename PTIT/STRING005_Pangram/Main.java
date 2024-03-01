package PTIT.STRING005_Pangram;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());
        while (test-- > 0) {
            boolean check = true;
            String inputs = sc.nextLine().toLowerCase();
            for (char c = 'a'; c <= 'z'; c++) {
                if (!inputs.contains(String.valueOf(c))) {
                    check = false;
                    break;
                }
            }
            System.out.println(check ? "true" : "false");
        }
    }
}