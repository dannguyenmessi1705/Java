public class OPPEncapsulationAccount {
    private String accountNumber;
    private String accountName;
    private double balance=0;
    public OPPEncapsulationAccount(String accountNumber, String accountName){
        this.accountName=accountName;
        this.accountName=accountName;
    }
    public OPPEncapsulationAccount(String accountNumber, String accountName, double balance){
        this.accountNumber=accountNumber;
        this.accountName=accountName;
        this.balance=balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount){
        this.balance+=amount;
    }
    public void withdraw(double amount){
        if(balance<amount) System.out.println("That amount exceeds your current balance.");
        else this.balance-=amount;
    }
    public void printInfo(){
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Account Name: " + this.accountName);
        System.out.println("Balance: " + this.balance);
    }
    public static void main(String[]args) {
        OPPEncapsulationAccount a1=new OPPEncapsulationAccount("1705", "Dan", 2000);
        a1.printInfo();
        a1.withdraw(2100);
        a1.deposit(600);
        System.out.println("Balance: "+a1.getBalance());
        a1.withdraw(2100);
        System.out.println("Balance: "+a1.getBalance());
        
    }
}
