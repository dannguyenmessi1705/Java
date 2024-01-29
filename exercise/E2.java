package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class E2 {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        for(int i = 0; i < len; i++){
            arr.add(sc.nextInt());
        }
        Collections.sort(arr);
        System.out.print(arr.get(arr.size()-2));
    }
}
