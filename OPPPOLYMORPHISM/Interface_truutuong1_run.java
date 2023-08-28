package OPPPOLYMORPHISM;

public class Interface_truutuong1_run {
	public static void main(String[]args) {
		Interfcae_truutuong1[] shapes=new Interfcae_truutuong1[3];
		shapes[0]=new Rectangle(3.4, 5.3);
		shapes[1]=new Circle(5.5);
		shapes[2]=new Rectangle(7.4, 4.3);
		for(int i=0;i<3;i++) {
			System.out.println("Dien tich cua shape["+i+"]:"+shapes[i].getArea());
			System.out.println("Chu vi cua shape["+i+"]:"+shapes[i].getPerimeter());
		}
	}
}
