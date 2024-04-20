package PTIT.LAB01_ClassMain_Main_Class;

import java.util.Scanner;

public class Main {
    public static void main(String[] $) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());
        while (test-- > 0) {
            String sentences = sc.nextLine();
            System.out.println(sentences.length() + " " + sentences.split("\\s+").length);
        }
    }
}
