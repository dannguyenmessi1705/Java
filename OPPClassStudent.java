public class OPPClassStudent{
    private String name;
    private int age;
    private String gender;
    private double gpa;
    public OPPClassStudent(String name, int age, String gender, double gpa){
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.gpa=gpa;
    }
    public void display(){
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
        System.out.println("Gender: "+gender);
        System.out.println("GPA: "+gpa);
    }
    public static void main(String[]args){
        OPPClassStudent st=new OPPClassStudent("Dan", 18, "Male", 3.2);
        st.display();
    }
}