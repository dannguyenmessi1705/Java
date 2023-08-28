package OPPENCAPSULATION;
import java.util.Scanner;
public class OPPEncapsulationDate {

        private int day;
        private int month;
        private int year;
        public OPPEncapsulationDate(int day, int month, int year){
            this.day=day;
            this.month=month;
            this.year=year;
        }
        public void setDate(int day, int month, int year){
            this.day=day;
            this.month=month;
            this.year=year;
        }
        public void setDay(int day){
            this.day=day;
        }
        public void setMonth(int month){
            this.month=month;
        }
        public void setYear(int year){
            this.year=year;
        }
        public int getDay(){
            return day;
        }
        public int getMonth(){
            return month;
        }
        public int getYear(){
            return year;
        }
        public void display(){
            String day=this.day+"", month=this.month+"", year=this.year+"";
            if(day.length()==1)  day="0"+day;
            if(month.length()==1) month="0"+month;
            System.out.println(day+"/"+month+"/"+year);
        }
        public static void main(String[]args) {
            OPPEncapsulationDate D=new OPPEncapsulationDate(1,1,1997);
            D.display();
            Scanner sc=new Scanner(System.in);
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            D.setDate(a, b, c);
            D.display();
            sc.close();
        }
    }
