import java.util.InputMismatchException;
import java.util.Scanner;

class TryCatchInJava {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=a/b;
            System.out.println(c);
            sc.close();}
            catch(ArithmeticException ex){
                System.out.println("Nhap lai so b phai khac 0");
            }
            catch(InputMismatchException ex){
                System.out.println("Xin hay nhap so, khong phai chu");
            }
            finally{
                System.out.println("Cam on ban da thuc hien chuong trinh");
            }
            
}
}
