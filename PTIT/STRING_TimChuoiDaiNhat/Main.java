package PTIT.STRING_TimChuoiDaiNhat;

import java.util.Scanner;

public class Main {
    public static String findLongestWord(String sentence) {
        String[] words = sentence.split(" ");
        String longestWord = "";
        for (String word : words) {
            if (word.length() >= longestWord.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }
    public static void main(String[] $) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());
        while (test-- > 0) {
            String s1 = sc.nextLine();
            System.out.println(findLongestWord(s1));
        }
    }
}