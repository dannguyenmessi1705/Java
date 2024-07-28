package CTDLGT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InsertionSort {
  static int[] insertionSort(int[] arr) {
    List<Integer> arrays = new ArrayList<>();
    Arrays.stream(arr).forEach(arrays::add);
    for (int i = 1; i < arrays.size(); i++) {
      for (int j = 0; j < i; j++) {
        if (arrays.get(i) < arrays.get(j)) {
          int temp = arrays.get(i);
          arrays.remove(i);
          arrays.add(j, temp);
        }
      }
      System.out.printf("%d: ", i);
      for (int k : arrays) {
        System.out.print(k + " ");
      }
      System.out.println();
    }

    return arrays.stream().mapToInt(Integer::valueOf).toArray();
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int test = Integer.parseInt(sc.nextLine());
    while (test-- > 0) {
      int[] arr = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
      arr = insertionSort(arr);
      System.out.println("Result:");
      for (int i : arr) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
    sc.close();
  }

}
