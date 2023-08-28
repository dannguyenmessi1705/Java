package OPPPOLYMORPHISM;

import java.util.Scanner;

class InnerClass_run {
	public static void main(String[]atgs) {
		InnerClass myOut = new InnerClass();
		InnerClass.SupInner myIntInner = myOut.new SupInner();
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		myOut.setX(a);
		myIntInner.setY(b);;
		System.out.println(myOut.getX()+myIntInner.getY());
		sc.close();
	}
}
