package PTIT.ELAB2302_Student_Class;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        while(true) {
            try {
                students.add(new Student(sc.nextLine(), Integer.parseInt(sc.nextLine())));
            } catch (Exception e){
                break;
            }
        }
        for (int i = 0; i < students.size(); i++) {
            students.get(i).display();
            if (i == students.size() - 1){
                System.out.println(Student.numberOfStudent);
            }
        }

    }
}

class Student {
    private String name;
    private int age;
    public static int numberOfStudent = 0;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        numberOfStudent++;
    }
    public void display(){
        if (age >= 18) {
            System.out.println(name);
        }
    }

}
