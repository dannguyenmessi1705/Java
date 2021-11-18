class Student1 {
	String name;
	int age;
	public Student1(){
	}
	public void display(){
	    System.out.println("Name: "+name);
        System.out.println("Age: "+age);
	}
}

public class OPPStudent {
	public static void main(String[] args) {
		Student1[] students = new Student1[3];
		for(int i=0;i<3;i++){
			students[i]=new Student1();
		}
		students[0].name="Tuan";
		students[1].name="Cuong";
		students[2].name="Duc";
		students[0].age=24;
		students[1].age=25;
		students[2].age=24;
		for (int i = 0; i < 3; i++) {
			students[i].display();
		}
	}
}