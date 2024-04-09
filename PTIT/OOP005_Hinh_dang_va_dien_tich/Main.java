package PTIT.OOP005_Hinh_dang_va_dien_tich;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());
        while (test-- > 0) {
            String name = sc.next();
            if (name.equals("Circle")) {
                double radius = sc.nextDouble();
                Circle circle = new Circle(name, radius);
                circle.displayInfo();
            } else {
                double width = sc.nextDouble();
                double height = sc.nextDouble();
                Rectangle rectangle = new Rectangle(name, width, height);
                rectangle.displayInfo();
            }
        }

    }
}

abstract class Shape {
    protected String name;
    public Shape(String name) {
        this.name = name;
    }
    public abstract double calculateArea();

    public void displayInfo() {
        System.out.printf("Shape:%s|Area:%.2f\n", name, calculateArea());
    }
}

class Circle extends Shape {
    private double radius;
    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;
    public Rectangle(String name, double width, double height) {
        super(name);
        this.width = width;
        this.height = height;
    }
    @Override
    public double calculateArea() {
        return width * height;
    }
}