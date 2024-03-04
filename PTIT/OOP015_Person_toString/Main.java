package PTIT.OOP015_Person_toString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());
        List<Person> persons = new ArrayList<>();
        while (test-- > 0){
            String name = sc.next();
            String address = sc.next();
            Person person = new Person(name, address);
            persons.add(person);
        }
        for(Person person : persons){
            System.out.println(person);
        }
    }
}
class Person {
    private String name;
    private String address;

    public Person() {
    }

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return name + " - " + address;
    }
}
