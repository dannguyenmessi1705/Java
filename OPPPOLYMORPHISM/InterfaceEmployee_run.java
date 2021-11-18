package OPPPOLYMORPHISM;

public class InterfaceEmployee_run {
	public static void main(String[]args) {
	InterfaceEmployee[] e=new InterfaceEmployee[2];
	e[0]=new PartTimeEmployee("Dan", 50000, 6);
	e[1]=new FullTimeEmployee("Thang", 40000);
	for(int i=0;i<2;i++) {
		System.out.println("Name: "+e[i].getName());
		System.out.println("Salary: "+e[i].calculateSalary());
	}
	}
}
