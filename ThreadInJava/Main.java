package ThreadInJava;

public class Main {
    public static void main(String[]args) {
    	System.out.println("Luong main bat dau chay:");
        ThreadOne t1 = new ThreadOne();
        t1.setName("A"); // Dat ten luong t1 la A
        t1.start(); // chay luong t1
        /* try {
            t1.sleep(3000); // cho luong t1 cho 1s
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        */ 
        ThreadTwo threadtwo = new ThreadTwo();
        Thread t2 = new Thread(threadtwo);
        t2.setName("B"); // Dat ten luong t2 la B
        t2.start(); // chay luong t2
        /* try {
            t2.sleep(1000); // cho luong t2 cho 1s
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
        */
        
        
        /* try {
            Thread.sleep(5000); // cho sau 3s roi moi thuc hien tiep tuc tat ca cac luong
            t1.stop(); // Lam chet luong, khong chay nua
            t2.stop(); // Lam chet luong, khong chay nua
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */
        try {
            t1.join(); // loi luong cho luong t1 thuc hien xong het roi moi den Luong main
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        } 
        try {
            t2.join(); // loi luong cho luong t2 thuc hien xong het roi moi den Luong main
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
        System.out.println(t1.isAlive()); // Kiem tra luong t1 con song khong
        System.out.println(t2.isAlive()); // Kiem tra luong t2 con song khong
        System.out.println("Luong main ket thuc:");
    }
    
}
