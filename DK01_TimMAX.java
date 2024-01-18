import java.util.*;
public class DK01_TimMAX {
    private int a;
    private int b;
    public DK01_TimMAX(int a, int b){
        this.a = a;
        this.b = b;
    }
    public int MAX(){
        if (this.a > this.b){
            return this.a;
        }
        else return this.b;
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        DK01_TimMAX max = new DK01_TimMAX(a ,b);
        System.out.print(max.MAX());
        sc.close();
    }
}
