import java.util.*;
public class CB07_HinhTron {
    public static void main(String[]arg){
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        double r = sc.nextDouble();
        final double pi = 3.14;
        double P = 2*r*pi;
        double S = pi*r*r;
        System.out.printf("%.3f %.3f", P, S);
        sc.close();
    }
}
