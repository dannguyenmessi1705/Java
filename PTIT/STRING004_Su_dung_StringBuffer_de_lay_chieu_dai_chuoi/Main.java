package PTIT.STRING004_Su_dung_StringBuffer_de_lay_chieu_dai_chuoi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());
        while (test-- > 0){
            StringBuffer str = new StringBuffer(sc.next());
            System.out.println(str.length());
        }
    }
}
