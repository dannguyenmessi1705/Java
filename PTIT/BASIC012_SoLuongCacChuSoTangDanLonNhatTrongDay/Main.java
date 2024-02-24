package PTIT.BASIC012_SoLuongCacChuSoTangDanLonNhatTrongDay;

import java.util.Scanner;

public class Main {
    public static int longestSortedSequence(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int max = 1;
        int count = 1;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] <= array[i + 1]) {
                count++;
                if (count > max) {
                    max = count;
                }
            } else {
                count = 1;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        while (n-- > 0) {
            String s = sc.nextLine();
            String [] arr = s.split("\\s+");
            int[] array = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                array[i] = Integer.parseInt(arr[i]);
            }
            System.out.println(longestSortedSequence(array));
        }
    }
}