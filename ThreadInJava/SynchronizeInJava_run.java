package ThreadInJava;
class SynchronizeInJava_run {
    public static void main(String[]arg) {
        SynchronizeInJava sharedata = new SynchronizeInJava();
        Synchronize1InJava thread1 = new Synchronize1InJava(sharedata);
        Synchronize1InJava thread2 = new Synchronize1InJava(sharedata);
        Synchronize1InJava thread3 = new Synchronize1InJava(sharedata);
        Synchronize1InJava thread4 = new Synchronize1InJava(sharedata);
        Synchronize1InJava thread5 = new Synchronize1InJava(sharedata);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        

    }    
}
