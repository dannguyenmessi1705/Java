package PTIT.EXCEPTION001_Exception;

import java.util.Scanner;

public class Main {
    public static void main(String[] $$$$) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());
        while (test-- > 0){
            String[] s = sc.nextLine().split("\\s+");
            Amount amount1 = new Amount(s[0], Integer.parseInt(s[1]));
            Amount amount2 = new Amount(s[2], Integer.parseInt(s[3]));
            try {
                System.out.println(amount1.add(amount2));
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}

class Amount {
    String currency;
    int amount;

    public Amount(String currency, int amount){
        this.currency = currency;
        this.amount = amount;
    }
    public int add(Amount amount) throws Exception{
        if (!this.currency.equals(amount.currency)) throw new Exception("Currency doesn't match");
        return this.amount + amount.amount;
    }
}