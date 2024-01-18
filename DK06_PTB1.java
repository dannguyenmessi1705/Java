import java.util.Locale;
import java.util.Scanner;
public class DK06_PTB1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split(" ");
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);
        if (a==0 && b==0){
            System.out.print("WOW");
        }
        else if (a == 0 && b != 0){
            System.out.print("NO");
        }
        else {
            System.out.printf("%.2f", (float)-b/a);
        }
        sc.close();
    }
}
