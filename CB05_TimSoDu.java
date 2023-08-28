import java.util.Scanner;
public class CB05_TimSoDu {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int du = a%b;
        System.out.print(du);
        sc.close();
    }
}