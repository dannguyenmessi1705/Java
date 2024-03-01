package PTIT.BASIC009_Tinh_Goc_Phan_Tu;

import java.util.Scanner;

public class Main {
    private int x, y;
    public Main(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int quadrant(){
        if (x == 0 || y == 0){
            return 0;
        }
        if (x < 0) {
            if (y < 0) return 3;
            else return 2;
        } else {
            if (y < 0) return 4;
            else return 1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.next());
        while (test-- > 0){
            Main n = new Main(sc.nextInt(), sc.nextInt());
            System.out.println(n.quadrant());
        }
    }
}
