package PTIT.LAB01_TwoSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static List<Integer> twoSum(List<Integer> list, int target) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            int complement = target - list.get(i);
            if (map.containsKey(complement)) {
                result.add(map.get(complement));
                result.add(i);
                return result;
            }
            map.put(list.get(i), i);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());
        while (test-- > 0) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(sc.nextInt());
            }
            int target = sc.nextInt();
            List<Integer> result = twoSum(list, target);
            System.out.println(result.isEmpty() ? "Not found" : result.get(0) + " " + result.get(1));
        }
    }
}