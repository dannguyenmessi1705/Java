package PTIT.INHERITANCE002_ChiecHop;

import java.util.ArrayList;

public class Main {
    public static void main(String[] $) {
        BoxWithMaxWeight box = new BoxWithMaxWeight(10);
        box.add(new Item("Saludo", 5));
        box.add(new Item("Pirkka", 5));
        box.add(new Item("Kopi Luwak", 5));
        System.out.println(box.isInBox(new Item("Saludo")));
        System.out.println(box.isInBox(new Item("Pirkka")));
        System.out.println(box.isInBox(new Item("Kopi Luwak")));
    }
}

class Item {
    private String name;
    private int weight;
    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }
    public Item(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
}

abstract class Box {
    abstract void add(Item item);
    abstract boolean isInBox(Item item);

}

class BoxWithMaxWeight extends Box {
    private final ArrayList<Item> items;
    private final int maxWeight;
    public BoxWithMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
        items = new ArrayList<>();
    }
    @Override
    public void add(Item item){
        int totalWeight = items.stream().mapToInt(Item::getWeight).sum();
        if (item.getWeight() + totalWeight <= maxWeight){
            items.add(item);

        }
    }
    @Override
    public boolean isInBox(Item item){
        for (Item i : items) {
            if (i.getName().equals(item.getName())) {
                return true;
            }
        }
        return false;
    }
}