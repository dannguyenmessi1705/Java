package OPPINHERITANCE;
class Student5toString {
	private String name;
	private String address;
	private double gpa;
	public Student5toString(String name, String address, double gpa) {
		this.name=name;
		this.address=address;
		this.gpa=gpa;
	}
	@Override
	public String toString() {
		return "Name: "+name+",\nAddress: "+address+",\nGPA: "+gpa;
	}
}
