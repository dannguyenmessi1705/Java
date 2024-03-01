package PTIT.BASIC011_So_Nho_Nhat_Trong_Khoang_Cach_Cua_Mang;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());
        while (test-- > 0){
            String arrayString = sc.nextLine().trim();
            String [] arrayStringSplit = arrayString.split("\\s+");
            if (arrayStringSplit.length < 2){
                System.out.println(0);
                continue;
            }
            int[] array = Arrays.stream(arrayStringSplit).mapToInt(Integer::parseInt).toArray();
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < array.length - 1; i++){
                if ((array[i+1] - array[i]) < min){
                    min = array[i+1] - array[i];
                }
            }
            System.out.println(min);
        }
    }
}
