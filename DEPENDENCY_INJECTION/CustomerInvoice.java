package DEPENDENCY_INJECTION;

public class CustomerInvoice {
    public static void main(String[]args) {
        Customer customer1 = new Customer(1705, "Dan", 30);
        Invoice invoice1 = new Invoice(1705, customer1, 90000);
        System.out.println("Customer Name: "+invoice1.getCustomerName());
        System.out.println("Amount: "+invoice1.getAmountAfterDiscount());
    }    
}
class Customer{
    private int id;
    private String name;
    private int discount;
    public Customer(int id, String name, int discount){
        this.id=id;
        this.name=name;
        this.discount=discount;
    }
    public int getId(){
        return id;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setDiscount(int discount){
        this.discount=discount;
    }
    public int getDiscount(){
        return discount;
    }
}
class Invoice{
    private int id;
    private double amount;
    private Customer customer;
    public Invoice(int id, Customer customer, double amount){
        this.id=id;
        this.customer=customer;
        this.amount=amount;
    }
    public int getId(){
        return id;
    }
    public void setCustomer(Customer customer){
        this.customer=customer;
    }
    public Customer getCustomer(){
        return customer;
    }
    public void setAmount(double amount){
        this.amount=amount;
    }
    public double getAmount(){
        return amount;
    }
    public String getCustomerName(){
        return customer.getName();
    }
    public double getAmountAfterDiscount(){
        return amount - amount*customer.getDiscount()/100;
    }

}