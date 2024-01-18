import java.util.Locale;
import java.util.Scanner;
public class DK04_LamTron {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        double a = sc.nextDouble();
        System.out.print(Math.round(a));
        sc.close();
    }
}
