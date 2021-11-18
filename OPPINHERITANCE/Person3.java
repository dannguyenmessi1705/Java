package OPPINHERITANCE;

class Person3 {
	private String name;
	private String address;
	private int age;
	public Person3(String name, int age, String address) {
		this.name=name;
		this.age=age;
		this.address=address;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public void setAddress(String address) {
		this.address=address;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getAddress() {
		return address;
	}
	public void display() {
		System.out.println("Name: "+name);
		System.out.println("Age: "+age);
		System.out.println("Address: "+address);
	}
}
class Student3 extends Person3{
	private double gpa;
	public Student3(String name, int age, String address, double gpa) {
		super(name, age, address);
		this.gpa=gpa;
	}
	public void setGpa(double gpa) {
		this.gpa=gpa;
	}
	public double getGpa() {
		return gpa;
	}
	@Override
	public void display() {
		super.display();
		System.out.println("GPA: "+gpa);
		
	}
	
}
class Teacher3 extends Person3{
	private int salary;
	public Teacher3(String name, int age, String address, int salary) {
		super(name, age, address);
		this.salary=salary;
	}
	public void setSalary(int salary) {
		this.salary=salary;
	}
	public int getSalary() {
		return salary;
	}
	@Override
	public void display() {
		super.display();
		System.out.println("Salary: "+salary);
	}
}