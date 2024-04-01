package PTIT.EXCEPTION004_KiemTraTenTuoi;

import java.util.Scanner;

public class Main {
    public static void main(String[] $$$$$) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());
        while (test-- > 0) {
            try {
                Person p = new Person(sc.nextLine(), Integer.parseInt(sc.nextLine()));
                System.out.println(p);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}

class Person {
    String name;
    int age;
    public Person(String name, int age) throws Exception{
        if (name == null || name.length()==0 || name.length() > 40){
            throw new Exception("Name is not valid");
        } else if (age < 0 || age > 120) {
            throw new Exception("Age is not valid");
        }
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString(){
        return String.format("Name: %s--Age:%d", this.name, this.age);
    }
}
