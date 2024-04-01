package PTIT.EXCEPTION002_KiemTraDiem;

import java.util.Scanner;

public class Main {
    public static boolean CheckFileExtension(String fileName) throws NotJavaFileException {
        if (fileName == null || fileName.length() == 0) {
            throw new NotJavaFileException("Not java file exception.Mark is -1");
        }
        if (fileName.endsWith(".java")){
            return true;
        } else return false;
    }

    public static void main(String[] $$$$$) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());
        while (test-- > 0){
            try{
                if(CheckFileExtension(sc.nextLine())){
                    System.out.println(1);
                } else System.out.println(0);
            }catch (NotJavaFileException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class NotJavaFileException extends Exception {
    public NotJavaFileException(String messeage){
        super(messeage);
    }
}