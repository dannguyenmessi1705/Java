package PTIT.ELAB2303_Class_MyStuff;

public class Main {
    public static void main(String[] args) {
        MyStuff m1 = new MyStuff("PC");
        MyStuff m2 = new MyStuff("PC");

        if (m2.equals(m1))
            System.out.println("value compared: same");
        else
            System.out.println("value compared: different");
        // b. Viết thêm câu lệnh so sánh hai tham chiếu và in ra same/different nếu tham chiếu là giống/khác
        if (m2.hashCode() == m1.hashCode())
            System.out.println("reference compared: same");
        else
            System.out.println("reference compared: different");
    }
}
class MyStuff {
    private String name;

    MyStuff(String name) {
        this.name = name;
    }
    @Override
    public boolean equals(Object obj) {
        MyStuff myStuff = (MyStuff) obj;
        if (myStuff.name.equals(this.name)) {
            return true;
        }
        return false;
    }
}
