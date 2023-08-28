package ThreadInJava;
// Khởi tạo Thread bằng cách 1
class ThreadOne extends Thread{
    @Override
    public void run() {
        for(int i=1; i<10; i++){
            System.out.println("ThreadOne: "+i);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                   e.printStackTrace();
            }
        }
    }
}
