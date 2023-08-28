package ThreadInJava;

import java.util.Random;

class Synchronize1InJava extends Thread{
    SynchronizeInJava sharedata;
    public Synchronize1InJava(SynchronizeInJava sharedata){
        this.sharedata=sharedata;
    }
    @Override
    public void run(){
        Random random = new Random();
        for(int i=0;i<5;i++){
            int ran = random.nextInt(5);
            sharedata.add(ran);
        }
    }
}
