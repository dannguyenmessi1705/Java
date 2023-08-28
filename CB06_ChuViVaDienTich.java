import java.util.Scanner;
public class CB06_ChuViVaDienTich {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int P = (a+b)*2;
        int S = a*b;
        System.out.print(P+"\n"+S);
        sc.close();
    }
}
