import java.util.Locale;
import java.util.Scanner;

public class DK05_SoChinhPhuong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        long a = sc.nextLong();
        if (Math.sqrt(a) == (int)Math.sqrt(a)){
            System.out.print("YES");
        }
        else System.out.print("NO");
        sc.close();
    }
}
