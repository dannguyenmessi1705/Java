package OPPPOLYMORPHISM;

public class Person1_run {
	public static void main(String[]args) {
		Person1 p1=new Employee1("Di Dan", "HY", 3300);
		Person1 p2=new Customer1("Van Thang", "HN", 10400);
		p1.display();
		p2.display();
	}
}
