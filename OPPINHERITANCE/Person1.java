package OPPINHERITANCE;

class Person1{
	private String name;
	private int dob;
	public Person1(String name, int dob) {
		this.name = name;
		this.dob = dob;
	}
	public int getDob() {
		return dob;
	}
	public void setDob(int dob) {
		this.dob=dob;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
}

class Students1 extends Person1 {
	private double gpa;
	public Students1(String name, int dob, double gpa) {
		super(name, dob);
		this.gpa=gpa;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa=gpa;
	}
}
