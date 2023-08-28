package CTDLGT;

import java.util.Scanner;

public class DayDonDieu {
    public static void main(String[]args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        boolean kt1=true;
        boolean kt2=true;
        for(int i=0;i<n-1;i++){
            if(a[i]<=a[i+1]) kt1=false;
            if(a[i]>=a[i+1]) kt2=false; 
        }
        if(kt1 || kt2){
            System.out.println("YES");
        }
        else System.out.println("NO");
        sc.close();
    }
}
