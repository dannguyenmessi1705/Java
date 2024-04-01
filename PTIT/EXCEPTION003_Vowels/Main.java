package PTIT.EXCEPTION003_Vowels;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void hasVowels(String str) throws Exception {
        Pattern pattern = Pattern.compile("[UEOAIueoai]");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            System.out.println("String has vowels");
        } else throw new Exception("String not contain vowels");
    }

    public static void main(String[] $$$$$$$$$) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());
        while (test-- > 0) {
            try {
                hasVowels(sc.nextLine());
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
