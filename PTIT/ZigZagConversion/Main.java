package PTIT.ZigZagConversion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static String convert(String s, int numRows) {
    List<String>[] arr = new ArrayList[numRows];
    for (int i = 0; i < numRows; i++) {
      arr[i] = new ArrayList<>();
    }
    int idx = 0, old_idx = 0;
    for (int i = 0; i < s.length(); i++) {
      arr[idx].add(Character.toString(s.charAt(i)));
      if (idx < numRows - 1 && idx >= old_idx) {
        old_idx = idx;
        idx++;
      } else {
        old_idx = idx;
        idx--;
        if (idx < 0) {
          if (numRows != 1) {
            idx = 1;
          } else idx = 0;
          old_idx = 0;
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    for (List<String> i : arr) {
      for (String j : i) {
        sb.append(j);
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println(convert(sc.nextLine(), sc.nextInt()));
    sc.close();
  }
}
