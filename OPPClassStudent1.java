class Student2{
    private String name;
    private char gender;
    public Student2(){
        name="Unknown";
        gender='u';
    }
    public Student2(String name){
        this.name=name;
        this.gender='u';
    }
    public Student2(char gender){
        this.gender=gender;
        this.name="Unknown";
    }
    public Student2(String name, char gender){
        this.name=name;
        this.gender=gender;
    }
    public void display(){
        System.out.println("Name: "+name);
        if(gender=='u') System.out.println("Gender: Unknown");
        if(gender=='m') System.out.println("Gender: Male");
        if(gender=='f') System.out.println("Gender: Female");
    }
}
public class OPPClassStudent1 {
    public static void main(String[]args) {
        Student2 s1=new Student2();
        s1.display();
        Student2 s2=new Student2("Dan");
        s2.display();
        Student2 s3=new Student2('f');
        s3.display();
        Student2 s4=new Student2("Dan", 'm');
        s4.display();
    }
}
