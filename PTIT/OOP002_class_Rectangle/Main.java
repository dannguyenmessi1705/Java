package PTIT.OOP002_class_Rectangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());
        while(test-- > 0) {
            Rectangle r = new Rectangle(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
            System.out.println(r);
        }
    }
}

class Rectangle{
    private int x, y, width, height;
    public Rectangle(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    @Override
    public String toString(){
        return String.format("Rectangle[x=%d,y=%d,width=%d,height=%d]", x, y, width, height);
    }

}