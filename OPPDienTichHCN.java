import java.util.Scanner;

class Rectangle{
	float a;
	float b;
	public void getInformation(){
		Scanner sc=new Scanner(System.in);
		a=sc.nextFloat();
		b=sc.nextFloat();
        sc.close();
	}
	public void display(){
		System.out.println("Area: "+(a*b));
		System.out.println("Perimeter: "+((a+b)*2));
	}
}

public class OPPDienTichHCN {
	public static void main(String[]args) {
		Rectangle r = new Rectangle();
		r.getInformation();
		r.display();
	}
}