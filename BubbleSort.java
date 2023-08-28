import java.util.*;

public class BubbleSort {
    public static void Swap(int a, int b) {
        int tmp = a;
        a = b;
        b = tmp;
    }

    public static void Sort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (a[i] < a[j]) {
                    Swap(a[i], a[j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Sort(a, n);
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
        sc.close();

    }
}
