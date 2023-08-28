package OPPINHERITANCE;
class Animal{
	public void sound() {
		System.out.println("The sound of an animal");
	}
}
class Cat extends Animal{
	public void sound() {
		System.out.println("Meow meow");
		}
	public void play() {
		System.out.println("a cat is playing a ball");
	}
}
public class UpDownCasting {
	public static void main(String arg[]) {
		Animal a1=new Cat();
		a1.sound();
		// a1.play(); khong thuc thi vi class cha khong co phuong thuc nay
		((Cat)a1).play();
		Animal a2=new Cat();
		Cat a3 = (Cat)a2;
		a3.play();
	}
}
