import java.util.*;
public class DK02_MAXOF3 {
    private int a, b, c;
    public DK02_MAXOF3(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public int MAX(){
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        return  max;
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] str = input.split(" ");
        int[] arr = new int[3];
        for(int i=0; i< str.length; i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        DK02_MAXOF3 max = new DK02_MAXOF3(arr[0], arr[1], arr[2]);
        System.out.print(max.MAX());
        sc.close();
    }
}
