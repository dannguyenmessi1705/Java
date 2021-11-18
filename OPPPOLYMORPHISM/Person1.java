package OPPPOLYMORPHISM;

abstract class Person1 {
	private String name;
	private String address;
	public Person1(String name, String address) {
		this.name = name;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public abstract void display();
}
class Employee1 extends Person1{
	private int salary;
	public Employee1(String name, String address, int salary) {
		super(name, address);
		this.salary = salary;
	}
	@Override
	public void display() {
		System.out.println("Employee name: "+super.getName());
		System.out.println("Employee address: "+super.getAddress());
		System.out.println("Employee salary: "+salary);
	}
}
class Customer1 extends Person1{
	private int balance;
	public Customer1(String name, String address, int balance) {
		super(name, address);
		this.balance = balance;
	}
	@Override
	public void display() {
		System.out.println("Customer name: "+super.getName());
		System.out.println("Customer address: "+super.getAddress());
		System.out.println("Customer balance: "+balance);
	}
}
