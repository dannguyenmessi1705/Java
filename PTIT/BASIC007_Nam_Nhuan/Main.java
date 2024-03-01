package PTIT.BASIC007_Nam_Nhuan;

import java.util.Scanner;

public class Main {
    private int year;
    public Main(int year){
        this.year = year;
    }
    public boolean checkLeap(){
        if (year % 4 == 0){
            if (year % 100 == 0){
                if (year % 400 == 0){
                    return true;
                } else return false;
            } else return true;
        } else return false;
    }
    @Override
    public String toString(){
        return String.format("%d : %s", year, checkLeap() ? "Leap-year" : "Non Leap-year");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.next());
        while (test-- > 0){
            Main n = new Main(sc.nextInt());
            System.out.println(n);
        }
    }
}
