public class OPPClassCircus{
    private double radius;
    public OPPClassCircus(double radius){
        this.radius=radius;
    }
    public double getArea(){
        return 3.14*radius*radius;
    }
    public double getCircumference(){
        return 3.14*2*radius;
    }
    public static void main(String[]args){
        OPPClassCircus cr=new OPPClassCircus(10);
        System.out.println(cr.getArea());
        System.out.println(cr.getCircumference());
    }
}