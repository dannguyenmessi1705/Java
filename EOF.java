import java.util.Scanner;

public class EOF {
    public static void mul(int a){
        System.out.println(a*5);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            while (sc.hasNextLine()){
                int a = sc.nextInt();
                mul(a);
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
