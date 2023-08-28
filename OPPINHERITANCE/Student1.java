package OPPINHERITANCE;

class Student1 extends OPPInheritance{
    private double gpa;
    public double getGpa(){    
        return gpa;
    }
    public void setGpa(double gpa){
        this.gpa=gpa;
    }
    public static void main(String[]args){
        Student1 s=new Student1();
        s.setName("Dan");
        s.setAge(19);
        s.setGpa(3.2);
        System.out.println("Name: "+ s.getName());
        System.out.println("Age: "+ s.getAge());
        System.out.println("GPA: "+ s.getGpa());
    }
}
