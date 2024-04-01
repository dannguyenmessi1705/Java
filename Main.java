import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void CheckFileExtension(String fileName) throws NotJavaFileException {
        if (fileName == null || fileName.length() == 0) {
            throw new NotJavaFileException("Not java file exception.Mark is -1");
        }
        if (fileName.endsWith(".java"))
            System.out.println(1);
        else
            System.out.println(0);
    }

    public static void main(String[] $$$$$) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());
        while (test-- > 0) {
            try {
                // Person p = new Person(sc.nextLine(), Integer.parseInt(sc.nextLine()));
                // System.out.println(p);
                CheckFileExtension(sc.nextLine());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class NotJavaFileException extends Exception {
    public NotJavaFileException(String message) {
        super(message);
    }
}

// class Person {
// String name;
// int age;
// public Person(String name, int age) throws Exception{
// if (name == null || name.length()==0 || name.length() > 40){
// throw new Exception("Name is not valid");
// } else if (age < 0 || age > 120) {
// throw new Exception("Age is not valid");
// }
// this.name = name;
// this.age = age;
// }
// @Override
// public String toString(){
// return String.format("Name: %s--Age:%d", this.name, this.age);
// }
// }
