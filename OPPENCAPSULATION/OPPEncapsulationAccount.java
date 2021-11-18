package OPPENCAPSULATION;
public class OPPEncapsulationAccount {
    private int id;
    private String name;
    private int balance=0;
    public OPPEncapsulationAccount(int id, String name){
        this.id=id;
        this.name=name;
    }
    public OPPEncapsulationAccount(int id, String name, int balance){
        this.id=id;
        this.name=name;
        this.balance=balance;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public int getBalance(){
        return balance;
    }
    public void setBalance(int balance){
        this.balance=balance;
    } 
    public void deposit(int amount){
        this.balance+=amount;
    }
    public void withdraw(int amount){
        if(balance<amount) System.out.println("That amount exceeds your current balance.");
        else this.balance-=amount;
    }
    public void display(){
        System.out.println("Id: " + this.id);
        System.out.println("Name: " + this.name);
        System.out.println("Balance: " + this.balance);
    }
    public static void main(String[]args) {
        OPPEncapsulationAccount a1=new OPPEncapsulationAccount(1705, "Dan", 2000);
        a1.display();
        a1.withdraw(2100);
        a1.deposit(600);
        System.out.println("Balance: "+a1.getBalance());
        a1.withdraw(2100);
        System.out.println("Balance: "+a1.getBalance());

        
    }
}
