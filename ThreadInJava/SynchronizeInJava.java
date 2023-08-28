package ThreadInJava;

class SynchronizeInJava {
    int x = 0;
    public synchronized void add(int plus){ // them tu khoa synchronized de dong bo cac thread, thread1 hoan tat xong moi den luowt thread2....
        x+=plus;
        System.out.println("\nDay x: " + x);
        for(int i=0;i<x;i++){
            System.out.print(i+" ");
        }
    }    
}
