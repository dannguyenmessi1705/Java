package OPPINHERITANCE;

class Person2 {
	private String name;
	private String gender;

	public Person2(String name, String gender) {
		this.name = name;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void display() {
		System.out.println("Name: " + name);
		System.out.println("Gender: " + gender);
	}
}

class Student2 extends Person2 {
	private int salary;
	public Student2(String name, String gender, int salary) {
		super(name, gender);
		this.salary=salary;
	}
	@Override
	public void display() {
		super.display();
		System.out.println("Salary: "+salary);
		
	}
}