package PTIT.BieuThuc;

import java.util.Scanner;

public class Main {
    public static void main(String[] $) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());
        while (test-- > 0) {
            String s = sc.nextLine();
            String[] nums = s.split(" ");
            System.out.printf("%d %d %d\n", Add.add(Integer.parseInt(nums[0]), Integer.parseInt(nums[1])), Subtract.subtract(Integer.parseInt(nums[0]), Integer.parseInt(nums[1])), Divide.divide(Integer.parseInt(nums[0]), Integer.parseInt(nums[1])));
        }
    }
}

class Add {
    public static int add(int a, int b) {
        return a + b;
    }
}

class Subtract {
    public static int subtract(int a, int b) {
        return a - b;
    }
}

class Divide {
    public static int divide(int a, int b) {
        if (b == 0) {
            return -1;
        }
        return a / b;
    }
}
