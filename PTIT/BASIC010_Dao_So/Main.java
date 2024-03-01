package PTIT.BASIC010_Dao_So;

import java.util.Scanner;

public class Main {
    public static int swapDigitPairs(int n) {
        int numRev = 0;
        int tmp = 1;
        while (n >= 10){
            int n1 = n % 10;
            n/=10;
            int n2 = n % 10;
            n/=10;
            numRev += tmp * (n1 * 10 + n2);
            tmp*=100;
        }
        if (n > 0){
            numRev += tmp * n;
        }
        return numRev;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.next());
        while (test-- > 0){
            int n = sc.nextInt();
            System.out.println(swapDigitPairs(n));
        }
    }
}
