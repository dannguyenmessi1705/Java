package PTIT.STRING001_TimChuCaiOViTriIndexNhatDinh;

import java.util.Scanner;

public class Main {
    public static void main(String[] $) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());
        while (test-- > 0) {
            String s = sc.next();
            int i = sc.nextInt();
            System.out.println("The character at position " + i + " is " + s.charAt(i));
        }
    }
}

