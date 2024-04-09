package PTIT.OOP004_Point_class;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());
        while (test-- > 0) {
            String[] input = sc.nextLine().split("\\s+");
            Point a = new Point();
            a.setX(Integer.parseInt(input[0]));
            a.setY(Integer.parseInt(input[1]));
            a.move(1, 1);

            Point b = new Point();
            b.setX(Integer.parseInt(input[2]));
            b.setY(Integer.parseInt(input[3]));

            System.out.printf("%.2f\n", a.distanceTo(b));

        }
    }
}

class Point {
    private int x;
    private int y;

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

    public void move(int dx, int dy){
        this.x += dx;
        this.y += dy;
    }

    public double distanceTo(Point p) {
        return Math.sqrt(Math.pow(this.x - p.getX(), 2) + Math.pow(this.y - p.getY(), 2));
    }
}