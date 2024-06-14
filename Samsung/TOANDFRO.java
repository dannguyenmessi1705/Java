package Samsung;

import java.util.Scanner;

public class TOANDFRO {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n == 0)
                    break;
                String s = sc.nextLine();
                String[][] arr = new String[s.length() / n][n];
                for (int i = 0; i < s.length() / n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (i % 2 == 1) {
                            arr[i][j] = String.valueOf(s.charAt(i * n + n - j - 1));
                        } else
                            arr[i][j] = String.valueOf(s.charAt(i * n + j));
                    }
                }
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < s.length() / n; j++) {
                        System.out.print(arr[j][i]);
                    }
                }
                System.out.println();
            } catch (Exception e) {
                break;
            }
        }
    }
}
