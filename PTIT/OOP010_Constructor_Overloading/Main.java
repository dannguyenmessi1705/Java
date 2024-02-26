package PTIT.OOP010_Constructor_Overloading;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("Tape measure");
        Product product2 = new Product("Plaster", "home improvement section");
        Product product3 = new Product("Tyre", 5);
        System.out.println(product1);
        System.out.println(product2);
        System.out.println(product3);
    }
}
class Product {
    private String name, location;
    private int weight;
    public Product(String name){
        this.name = name;
        this.location = "shelf";
        this.weight = 1;
    }
    public Product(String name, String location) {
        this.name = name;
        this.location = location;
        this.weight = 1;
    }
    public Product(String name, int weight) {
        this.name = name;
        this.location = "shelf";
        this.weight = weight;
    }
    @Override
    public String toString() {
        return String.format("%s (%dkg) can be found from the %s", name, weight, location);
    }
}
