package CTDLGT;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
  static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
  static void bubbleSort(int[] arr) {
    for (int i = 0; i < arr.length-1; i++) {
      for (int j = 0; j < arr.length - i -1; j++) {
        if (arr[j] > arr[j+1]) {
          swap(arr, j, j+1);
        }
      }
      System.out.printf("%d: ", i);
      for (int k : arr) {
        System.out.print(k + " ");
      }
      System.out.println();
    }
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int test = Integer.parseInt(sc.nextLine());
    while (test-- > 0) {
      int[] arr = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
      bubbleSort(arr);
      System.out.println("Result:");
      for (int i : arr) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
    sc.close();
  }

}
