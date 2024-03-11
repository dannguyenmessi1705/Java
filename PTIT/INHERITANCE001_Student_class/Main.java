package PTIT.INHERITANCE001_Student_class;

public class Main {
    public static void main(String[] $) {
        Student s = new Student("Ollie", "6381 Hollywood Blvd. Los Angeles 90028");
        System.out.println(s);
        System.out.println("Study credits "+s.getCredit());
        s.study();
        System.out.println("Study credits "+s.getCredit());
    }
}

class Person {
    private String name;
    private String address;
    public Person(String name, String address){
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return name + " - " + address;
    }
}
class Student extends Person {
    private static int credit = 0;
    public Student(String name, String address) {
        super(name, address);
    }
    public void study() {
        credit++;
    }
    public int getCredit() {
        return credit;
    }
}