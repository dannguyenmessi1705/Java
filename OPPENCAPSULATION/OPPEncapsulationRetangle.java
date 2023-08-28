package OPPENCAPSULATION;
class OPPEncapsulationRetangle {
    private double width;
    private double length;
    public OPPEncapsulationRetangle(){
        
    }
    public OPPEncapsulationRetangle(double length, double width){
        this.length=length;
        this.width=width;
    }
    public double getLength(){
        return length;
    }
    public void setLength(double length){
        this.length=length;
    }
    public double getWidth(){
        return width;
    }
    public void setWidth(double width){
        this.width=width;
    }
    public double getArea(){
        return length*width;
    }
    public double getPerimeter(){
        return (length+width)*2;
    }
    public static void main(String[]args) {
        OPPEncapsulationRetangle a = new OPPEncapsulationRetangle(4, 5);
        System.out.println("Dien tich = "+a.getArea());
        System.out.println("Chu vi = "+a.getPerimeter());
        a.setLength(6);
        a.setWidth(7);
        System.out.println("Dien tich = "+a.getArea());
        System.out.println("Chu vi = "+a.getPerimeter());

    }
}

