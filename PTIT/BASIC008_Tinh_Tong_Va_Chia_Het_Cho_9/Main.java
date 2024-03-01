package PTIT.BASIC008_Tinh_Tong_Va_Chia_Het_Cho_9;
// 100 to 200
public class Main {
    public static void main(String[] args) {
        int sum = 0;
        System.out.println("Numbers between 100 and 200, divisible by 9:");
        for (int i = (int) Math.ceil((double) 100/9); i <= (int) Math.floor((double)200/9); i++){
            System.out.println(i*9);
            sum+=i*9;
        }
        System.out.println(sum);
    }
}
