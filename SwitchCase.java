import java.util.InputMismatchException;
import java.util.Scanner;

public class SwitchCase {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        try {
            int a = sc.nextInt();
            switch (a){
                case 1,3,5,7,8,10,12:
                    System.out.println(31);
                    break;
                case 4,6,9,11:
                    System.out.println(30);
                    break;
                default:
                    System.out.println(28);
            }
        } catch (InputMismatchException a){
            System.out.println("Nhap so di");
        }
        sc.close();
    }
}
