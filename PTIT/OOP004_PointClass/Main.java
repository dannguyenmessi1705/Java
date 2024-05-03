package PTIT.OOP004_PointClass;

import java.util.Scanner;

public class Main {
    public static void main(String[] $) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());
        while (test-- > 0) {
            Point a = new Point(sc.nextInt(), sc.nextInt());
            Point b = new Point(sc.nextInt(), sc.nextInt());
            a.move(1, 1);
            System.out.printf("%.2f\n", a.distanceTo(b));
        }
    }
}

class Point {
    private int x, y;
    public Point() {
        x = 0;
        y = 0;
    }
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
    double distanceTo(Point p){
        return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
    }
}

