package DEPENDENCY_INJECTION;

public class DuongThangVaDiem {
    public static void main(String[]args) {
        Point begin = new Point(3, 5);
        Point end = new Point(6, 9);
        Line l1 = new Line(begin, end);
        System.out.println(l1.getLength());
        Line l2 = new Line(5, 7, 11, 15);
        System.out.println(l2.getLength());
    }
}
class Point{
    private int x, y;
    public Point(int x, int y){
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
class Line{
    private Point begin;
    private Point end;
    public Line(Point begin, Point end){
        this.begin = begin;
        this.end = end;
    }
    public Line(int x1, int y1, int x2, int y2){
        this.begin = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }
    public void setBegin(Point begin){
        this.begin = begin;
    }
    public void setEnd(Point end){
        this.end = end;
    }
    public Point getBegin(){
        return begin;
    }
    public Point getEnd(){
        return end;
    }
    public double getLength(){
        return Math.sqrt(Math.pow(begin.getX()-end.getX(), 2)+Math.pow(begin.getY()-end.getY(), 2));
    }

}
