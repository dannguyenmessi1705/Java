package Samsung;

import java.util.Scanner;

public class FNDSTR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= t; i++) {
            try {
                String s = sc.nextLine();
                String p = sc.nextLine();
                int count = 0;
                while (p.indexOf(s) != -1) {
                    count++;
                    p = p.substring(p.indexOf(s) + 1);
                }
                System.out.println("#" + i + " " + count);
            } catch (Exception e) {
                break;
            }

        }
    }
}
