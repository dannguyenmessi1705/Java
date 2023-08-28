package CTDLGT;

import java.util.ArrayList;
import java.util.Scanner;

public class XepVaoMang {
    public static void main(String[]args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] a=new int[n];
        int[] b=new int[m];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        for(int i=0;i<m;i++){
            b[i]=sc.nextInt();
        }
        ArrayList<Integer> c = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i]<b[j]) c.add(a[i]);
                else c.add(b[i]);
            }
        }
        for(int i=0;i<c.size();i++)
            System.out.print(c.get(i) + " ");
        sc.close();
    }
}
