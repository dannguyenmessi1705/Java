package DEPENDENCY_INJECTION;

public class TamGiacTrongToaDo {
    public static void main(String[]args){
        Point1 vertice1 = new Point1(1, 3);
        Point1 vertice2 = new Point1(2, 3);
        Point1 vertice3 = new Point1(4, 2);
        Triangle p1 = new Triangle(vertice1, vertice2, vertice3);
        System.out.println(p1.getPerimeter());
        Triangle p2 = new Triangle(4, 5, 2, 6, 3, 7);
        System.out.println(p2.getPerimeter());

    }
}
class Point1{
    private int x, y;
    public Point1(int x, int y){
        this.x=x;
        this.y=y;
    }
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
class Triangle{
    private Point1 vertice1, vertice2, vertice3;
    public Triangle(Point1 vertice1, Point1 vertice2, Point1 vertice3){
        this.vertice1 = vertice1;
        this.vertice2 = vertice2;
        this.vertice3 = vertice3;
    }
    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3){
        this.vertice1 = new Point1(x1, y1);
        this.vertice2 = new Point1(x2, y2);
        this.vertice3 = new Point1(x3, y3);
    }
    public double getPerimeter(){
        double l1 = Math.sqrt(Math.pow(vertice1.getX()-vertice2.getX(), 2)+Math.pow(vertice1.getY()-vertice2.getY(), 2));
        double l2 = Math.sqrt(Math.pow(vertice1.getX()-vertice3.getX(), 2)+Math.pow(vertice1.getY()-vertice3.getY(), 2));
        double l3 = Math.sqrt(Math.pow(vertice2.getX()-vertice3.getX(), 2)+Math.pow(vertice2.getY()-vertice3.getY(), 2));
        return l1+l2+l3;
    }
}

