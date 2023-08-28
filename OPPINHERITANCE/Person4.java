package OPPINHERITANCE;

class Person4 {
	private String name;
	private int salary;
	public Person4(String name, int salary) {
		this.name=name;
		this.salary=salary;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setSalary(int salary) {
		this.salary=salary;
	}
	public String getName() {
		return name;
	}
	public int getSalary() {
		return salary;
	}
	public void display() {
		System.out.println("Name: "+ name);
		System.out.println("Salary: "+ salary);
	}
}
class Manager4 extends Person4{
	private int bonus;
	public Manager4(String name, int salary, int bonus) {
		super(name, salary);
		this.bonus=bonus;
	}
	public int getSalary() {
		return super.getSalary()+this.bonus;
	}
	public void setBonus(int bonus) {
		this.bonus=bonus;
	}
	public int getBonus() {
		return bonus;
	}
	public void display() {
		System.out.println("Name: "+ getName());
		System.out.println("Salary: "+ getSalary());
	}
}
