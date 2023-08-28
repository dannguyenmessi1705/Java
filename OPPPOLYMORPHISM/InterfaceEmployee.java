package OPPPOLYMORPHISM;

interface InterfaceEmployee {
	public int calculateSalary();
	public String getName();
}
abstract class Employee implements InterfaceEmployee{
	private String name;
	private int paymentPERHOUR;
	public Employee(String name, int paymentPERHOUR) {
		super();
		this.name = name;
		this.paymentPERHOUR = paymentPERHOUR;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPaymentPERHOUR() {
		return paymentPERHOUR;
	}
	public void setPaymentPERHOUR(int paymentPERHOUR) {
		this.paymentPERHOUR = paymentPERHOUR;
	}
}
class PartTimeEmployee extends Employee{
	private int workingHours;

	public PartTimeEmployee(String name, int paymentPERHOUR, int workingHours) {
		super(name, paymentPERHOUR);
		this.workingHours = workingHours;
	}
	@Override
	public int calculateSalary() {
		return super.getPaymentPERHOUR()*this.workingHours;
	}
}
class FullTimeEmployee extends Employee{
	public FullTimeEmployee(String name, int paymentPERHOUR) {
		super(name, paymentPERHOUR);
	}
	@Override
	public int calculateSalary() {
		return super.getPaymentPERHOUR()*8;
	}
}

