package ThreadInJava;
public class DongBo {
    public static void main(String[]arg) {
        System.out.println("Bat dau thuc hien: ");
        Sync luong = new Sync();
        Luong1 luong1 = new Luong1(luong);
        Luong2 luong2 = new Luong2(luong);
        luong1.start();
        luong2.start();
        try {
            luong1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            luong2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ket thuc: ");

    }    
}
class Sync{
    public synchronized void display(int x) { // Phuong thuc dong bo
        for(int i=1;i<=10;i++){
            int n = x*i;
            System.out.println(n);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Luong1 extends Thread{
    Sync l1;
    public Luong1(Sync l1){
        this.l1=l1;
    }
    @Override
    public void run(){
        l1.display(5);
    }
}
class Luong2 extends Thread{
    Sync l2;
    public Luong2(Sync l2){
        this.l2=l2;
    }
    @Override
    public void run(){
        l2.display(3);
    }
}
