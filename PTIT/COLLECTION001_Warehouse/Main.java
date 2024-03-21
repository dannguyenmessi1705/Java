package PTIT.COLLECTION001_Warehouse;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Warehouse w = new Warehouse();
        w.addProduct("milk", 10);
        w.addProduct("coffee", 7);
        System.out.printf("prices:\n" +
                "milk: %d\n" +
                "coffee: %d\n" +
                "sugar: %d", w.stock("milk"), w.stock("coffee"), w.stock("sugar"));
    }
}

class Warehouse {
    private HashMap<String, Integer> product = new HashMap<>();
    public void addProduct(String product, int stock){
        this.product.put(product, stock);
    }
    public int stock(String product){
        return this.product.getOrDefault(product, -99);
    }
}