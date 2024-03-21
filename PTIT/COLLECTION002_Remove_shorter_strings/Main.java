package PTIT.COLLECTION002_Remove_shorter_strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public void removeShorterStrings(ArrayList<String> list){
        for (int i=0; i < list.size() ; i++) {
            list.remove(list.get(i).length() <= list.get(i+1).length() ? i : i+1);
            if (i+1 == list.size() - 1) {
                break;
            }
        }
        list.forEach(s -> System.out.print((list.getLast().equals(s)) ? s : s + " "));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());
        while (test-- > 0){
            Main m = new Main();
            String[] arr = sc.nextLine().split(" ");
            ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));
            m.removeShorterStrings(list);
            System.out.println();
        }
    }
}
