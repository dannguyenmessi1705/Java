
public class Main {
    public static void main(String[] args) {
        Cha c = new Cha.Con("ha", 18);
        System.out.println(c.ten + " " + c.tuoi);

    }

}
class Cha {
    protected String ten;
    protected int tuoi;

    public Cha(String ten, int tuoi) {
        this.ten = ten;
        this.tuoi = tuoi;
    }
    static class Con extends Cha{

        public Con(String ten, int tuoi) {
            super(ten, tuoi);
        }
    }
}