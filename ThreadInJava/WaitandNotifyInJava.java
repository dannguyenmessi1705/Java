package ThreadInJava;

public class WaitandNotifyInJava {
    public static void main(String[]args) {
        Thread1 t1 = new Thread1();
        t1.start();
        synchronized(t1){ // dong bo luong t1 o duoi
        try {
            System.out.println("Cho cho luong t1 hoan tat...");
            t1.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Total = "+ t1.total);
        }
    }
}
class Thread1 extends Thread{
    int total = 0;
    @Override
    public void run() {
        synchronized(this){ // dong bo luong voi o tren
        for(int i=0;i<100;i++){
            total+=i;
        }
        notify();
    }
    }
}
