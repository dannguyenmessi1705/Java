package PTIT.INHERITANCE003_Grocery_Bill;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] $) {
        Employee clerk1 = new Employee("Grocery Bill");
        GroceryBill gb = new GroceryBill(clerk1);
        gb.add(new Item("item 1", 2.3, 0));
        gb.add(new Item("item 2", 3.45, 0));
        System.out.println(gb+"\n");

        Employee clerk2 = new Employee("Discount Bill");
        DiscountBill db = new DiscountBill(clerk2);
        db.add(new Item("item 3", 20, 15));
        db.add(new Item("item 4", 40, 35));
        db.add(new Item("item 5", 50, 55));
        System.out.println(db);
    }
}

class Item {
    private String name;
    private double price;
    private double discount;
    public Item(String name, double price, double discount){
        this.discount = discount;
        this.name = name;
        this.price = price;
    }
    public double getPrice(){
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    @Override
    public String toString(){
        return String.format("%s $%.2f (-$%.2f)", name, price, discount);
    }
}

class Employee {
    private String name;
    public Employee(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}

class GroceryBill {
    private Employee clerk;
    private List<Item> receipt;
    private double total;

    public GroceryBill(Employee clerk){
        this.clerk = clerk;
        this.receipt = new ArrayList<>();
        this.total = 0.0;
    }

    public void add(Item i){
        receipt.add(i);
        total += i.getPrice();
    }

    public double getTotal() {
        return total;
    }

    public Employee getClerk(){
        return clerk;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("items:\n");
        for (Item item : receipt) {
            sb.append("   ").append(item).append("\n");
        }
        sb.append("total: $").append(String.format("%.2f", total)).append("\n");
        sb.append("Clerk: ").append(clerk.getName());
        return sb.toString();
    }
}

class DiscountBill extends GroceryBill{
    private double discountAmount;
    public DiscountBill(Employee clerk){
        super(clerk);
        this.discountAmount = 0.0;
    }

    @Override
    public void add(Item i){
        super.add(i);
        discountAmount += i.getDiscount();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(super.toString());
        sb.replace(sb.indexOf("total:"), sb.length(), "");
        sb.append("sub-total: $").append(String.format("%.2f", super.getTotal())).append("\n");
        sb.append("discount: $").append(String.format("%.2f", discountAmount)).append("\n");
        sb.append("total: $").append(String.format("%.2f", super.getTotal() - discountAmount)).append("\n");
        sb.append("Clerk: ").append(super.getClerk().getName());
        return sb.toString();
    }
}

