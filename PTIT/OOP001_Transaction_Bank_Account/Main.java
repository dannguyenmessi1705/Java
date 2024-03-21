package PTIT.OOP001_Transaction_Bank_Account;

public class Main {
    public static void main(String[] args) {
        BankAccount savings = new BankAccount("Jimmy");

        savings.deposit(10.00);

        savings.deposit(50.00);

        savings.deposit(10.00);

        savings.deposit(70.00);

        savings.transactionFee(5.00);

        savings.transactionFee(10.00);
    }
}

class BankAccount {
    private String id;
    private double balance;
    private int transaction = 0;
    public BankAccount(String id){
        this.id = id;
    }
    public double getBalance(){
        return balance;
    }
    public String getID(){
        return id;
    }
    public int getTransaction(){
        return transaction;
    }
    public void deposit(double amount) {
        this.balance += amount;
        this.transaction++;
    }
    public void withdraw(double amount) {
        if (balance >= amount){
            this.balance -= amount;
            this.transaction++;
        }
    }
    public void transactionFee(double fee){
        double amount = 0;
        int count = transaction;
        while (count > 0){
            amount += fee * count;
            count--;
        }
        balance -= amount;
        System.out.println(balance >= 0);
    }
}