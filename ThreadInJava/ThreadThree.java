package ThreadInJava;
// Khởi tạo Thread bằng cách 3
class ThreadThree {
    public static void main(String[]args) {
    Thread threadthree = new Thread(new Runnable(){
        @Override
        public void run() {
            for(int i=1;i<10;i++){
                System.out.println("ThreadThree: "+i);
            }
        }
    });
    threadthree.start();    
// cách 4
    Thread threadfour = new Thread(() -> {
    for(int i=1;i<10;i++){
        System.out.println("ThreadFour: "+i);
    }
});
threadfour.start();  
}
}
