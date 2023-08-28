import java.util.Scanner;

public class random {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int min=sc.nextInt();
        int max=sc.nextInt();
        int size=max-min+1;
        int random=(int)(Math.random()*size)+min;
        System.out.println(random);
        sc.close();
    }
    
}
