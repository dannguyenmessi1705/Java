package PTIT.LAB01_BigDec_BigDecimal;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());
        while (test-- > 0) {
            String[] numbers = sc.nextLine().split(" ");
            BigDecimal sum = BigDecimal.ZERO;

            for (String number : numbers) {
                String[] num = number.split("\\.");
                sum = sum.add(new BigDecimal(number).subtract(new BigDecimal(num[0])));
            }

            System.out.println(sum);

        }
    }
}