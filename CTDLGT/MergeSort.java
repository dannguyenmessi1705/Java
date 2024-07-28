package CTDLGT;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
  static void merge(int[] arr, int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;
    int[] x = new int[n1];
    int[] y = new int[n2];
    for (int i = 0; i < n1; i++) {
      x[i] = arr[left + i];
    }
    for (int j = 0; j < n2; j++) {
      y[j] = arr[mid + 1 + j];
    }
    int i = 0, j = 0, k = left;
    while (i < n1 && j < n2) {
      arr[k++] = x[i] < y[j] ? x[i++] : y[j++];
    }
    while (i < n1) {
      arr[k++] = x[i++];
    }
    while (j < n2) {
      arr[k++] = y[j++];
    }
  }
  static void mergeSort(int[] arr, int left, int right) {
    if (left < right) {
      int mid = left + (right - left)/2;
      mergeSort(arr, left, mid);
      mergeSort(arr, mid+1, right);
      merge(arr, left, mid, right);
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int test = Integer.parseInt(sc.nextLine());
    while (test-- > 0) {
      int[] arr = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
      mergeSort(arr, 0, arr.length-1);
      System.out.println("Result:");
      for (int i : arr) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
    sc.close();
  }

}
