package PTIT.ELAB2310_DefinedException;

import java.util.Scanner;

class FileNameFormatExeption extends Exception {
    // Định nghĩa ngoại lệ mới
    public FileNameFormatExeption(String s){
        super(s);
    }
}

class Test {
    public static void open_file(String s){
        try {
            // Gọi phương thức f() ném ngoại lệ
            f(s);
        } catch (FileNameFormatExeption fname) {
            System.out.println(fname.getMessage());
        } catch (Exception e){
            System.out.println("Exception");
        }
    }

    public static void f(String s) throws FileNameFormatExeption{
        // Định nghĩa phương thức f()
        if (s == null || s.isEmpty() || s.split("\\s+").length > 1) throw new FileNameFormatExeption("File name format");
        System.out.println("File opened");
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Test.open_file(s);
        sc.close();
    }
}
