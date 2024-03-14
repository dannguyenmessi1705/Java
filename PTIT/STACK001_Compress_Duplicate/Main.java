package PTIT.STACK001_Compress_Duplicate;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public Queue<Integer> compressDuplicates(Stack<Integer> s){
        Queue<Integer> result = new LinkedList<>();
        while (!s.isEmpty()){
            int count = 1;
            int top = s.pop();
            while (!s.isEmpty() && s.peek() == top){
                s.pop();
                count++;
            }
            result.add(count);
            result.add(top);
        }
        return result;
    }
    public static void main (String[] $){
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());
        while (test-- > 0){
            Stack<Integer> s = new Stack<>();
            String[] arr = sc.nextLine().split(" ");
            for (int i = arr.length - 1; i >= 0; i--){
                s.push(Integer.parseInt(arr[i]));
            }
            Main main = new Main();
            Queue<Integer> result = main.compressDuplicates(s);
            while (!result.isEmpty()){
                if (result.size() == 1){
                    System.out.print(result.poll());
                    break;
                }
                System.out.print(result.poll() + " ");
            }
            System.out.println();
        }
    }
}
