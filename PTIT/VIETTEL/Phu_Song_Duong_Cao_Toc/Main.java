package PTIT.VIETTEL.Phu_Song_Duong_Cao_Toc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static int findLargeSpace(Integer m, Integer n, List<Integer> positions) {
    Collections.sort(positions);
    int max = positions.get(0);
    for (int i = 0; i < positions.size() - 1; i++) {
      int dis = positions.get(i+1) - positions.get(i);
      if (dis > max) {
        max = dis;
      }
    }
    max = Math.max(max, m - positions.get(positions.size() - 1));
    return max;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt();
    int n = sc.nextInt();
    List<Integer> positions = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      positions.add(sc.nextInt());
    }
    System.out.println(findLargeSpace(m, n, positions));
    sc.close();
  }
}

/*
Để phủ sóng tuyến đường cao tốc, các kỹ sư mạng lưới thiết kế đặt các trạm thu phát sóng dọc tuyến đường.

Khoảng trống được định nghĩa là một đoạn đường mà trên đoạn đường đó không có trạm thu phát sóng nào. Có một KPI mà các kỹ sư mạng lưới quan tâm là: khoảng trống lớn nhất trên tuyến đường.

Đường có độ dài M mét, được đánh tọa độ chẵn theo mét từ 0 đến M. Có N trạm trên đường. Hãy tính khoảng trống lớn nhất trên tuyến đường.

Input Format

Integer m: độ dài quãng đường (mét)

Integer n: số lượng trạm được đặt trên quãng đường

Integer[n] positions: số nguyên p là tọa độ của một trạm (0 <= p <= M)

Constraints

0 < M <= 10^9

0 < N <= 10^6

Output Format

Integer result: độ dài khoảng trống lớn nhất trên đường
 */