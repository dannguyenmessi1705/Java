package PTIT.OOP009_Slope_Point;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());
        while (test-- > 0) {
            Point p1 = new Point(sc.nextInt(), sc.nextInt());
            Point p2 = new Point(sc.nextInt(), sc.nextInt());
            System.out.println(p1.slope(p2));
        }
    }
}

class Point {
    private int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public double slope(Point other) {
        if (other.x == x) {
            return -1;
        }
        if (other.y - y == 0 && other.x - x < 0) {
           return  (double) (other.y - y) / (other.x - x) * (-1);
        }
        return (double) (other.y - y) / (other.x - x);
    }
}
