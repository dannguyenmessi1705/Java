import java.util.Scanner;
public class CB03_Tong3SoNguyen {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr  = str.split(" ");
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);
        int c = Integer.parseInt(arr[2]);
        int sum = a+b+c;
        System.out.print(sum);
        sc.close();
    }
}
