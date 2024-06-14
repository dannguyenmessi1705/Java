package Samsung;

import java.util.Scanner;

public class ABSYSE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String ss = sc.nextLine();
            String[] s = ss.split(" ");
            if (s[0].indexOf("machula") != -1) {
                System.out.println(Integer.parseInt(s[4]) - Integer.parseInt(s[2]) + " + " + s[2] + " = " + s[4]);
            } else if (s[2].indexOf("machula") != -1) {
                System.out.println(s[0] + " + " + (Integer.parseInt(s[4]) - Integer.parseInt(s[0])) + " = " + s[4]);
            } else if (s[4].indexOf("machula") != -1){
                System.out.println(s[0] + " + " + s[2] + " = " + (Integer.parseInt(s[0]) + Integer.parseInt(s[2])));
            } else {
                continue;
            }
        }
    }
}
