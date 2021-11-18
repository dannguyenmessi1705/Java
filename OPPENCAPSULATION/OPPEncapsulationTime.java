package OPPENCAPSULATION;
class OPPEncapsulationTime {
    private int hour;
    private int minute;
    private int second;
    public OPPEncapsulationTime(int hour, int minute, int second){
        this.hour=hour;
        this.minute=minute;
        this.second=second;
    }
    public void setTime(int hour, int minute, int second){
        this.hour=hour;
        this.minute=minute;
        this.second=second;
    }
    public void setHour(int hour){
        this.hour=hour;
    }
    public void setMinute(int minute){
        this.minute=minute;
    }  
    public void setSecond(int second){
        this.second=second;
    } 
    public int getHour(){
        return hour;
    }
    public int getMinute(){
        return minute;
    }  
    public int getSecond(){
        return second;
    } 
    public void nextSecond(){
        if(second==59 && minute==59 && hour==23){
            this.second=0;
            this.minute=0;
            this.hour=0;
            return;
        }
        if(second==59 && minute==59){
            this.hour++;
            this.minute=0;
            this.second=0;
            return;
        }
        if(second==59){
            this.second=0;
            this.minute++;
            return;
        }
        this.second++;
    }
    public void previousSecond(){
        if(hour==0 && minute==0 && second==0){
            this.hour=23;
            this.second=59;
            this.minute=59;
            return;
        }
        if(minute==0 && second==0){
            this.hour--;
            this.minute=59;
            this.second=59;
            return;
        }
        if(second==0){
            this.second=59;
            this.minute--;
            return;
        }
        this.second--;
    }
    public void display(){
        String second=this.second+"", minute=this.minute+"", hour=this.hour+"";
        if(second.length()==1) second="0"+second;
        if(minute.length()==1) minute="0"+minute;
        if(hour.length()==1) hour="0"+hour;
        System.out.println(hour+":"+minute+":"+second);
    }
    public static void main(String[]args){
        OPPEncapsulationTime t=new OPPEncapsulationTime(12, 1, 1);
        t.display();
        t.setTime(23, 59, 59);
        t.display();
        t.nextSecond();
        t.display();
        t.setTime(7, 0, 0);
        t.previousSecond();
        t.display();
    }
}
