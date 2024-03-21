package PTIT.INHERITANCE006_Animal;

public class Main {
    public static void main(String[] $) {
        Fish fish = new Fish();
        fish.play();
        fish.walk();

        Cat cat = new Cat("Fluffy");
        cat.play();
        cat.eat();

        Spider spider = new Spider();
        spider.eat();

        cat.walk();
        spider.walk();

    }
}

interface Pet {
    public String getName();

    public void setName(String name);

    public void play();
}

class Animal {
    protected int legs;
    protected Animal(int legs) {
        this.legs = legs;
    }
    public void walk(){
        System.out.printf("This animal walks on %d legs.\n", legs);
    }
    public void eat(){}
}

class Spider extends Animal {
    public Spider() {
        super(8);
    }
    @Override
    public void eat(){
        System.out.println("The spider eats a fly.");
    }
}

class Fish extends Animal implements Pet{
    private String name;
    public Fish(){
        super(0);
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void play() {
        System.out.println("Fish swim in their tanks all day.");
    }
    @Override
    public void walk(){
        super.walk();
        System.out.println("Fish, of course, can't walk; they swim.");
    }
    @Override
    public void eat(){
        System.out.println( "Fish eat pond scum.");
    }
}

class Cat extends Animal implements Pet{
    private String name;
    public Cat(String name){
        super(4);
        this.name = name;
    }
    public Cat(){
        super(4);
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void play() {
        System.out.printf("%s likes to play with string.\n", name);
    }
    @Override
    public void eat(){
        System.out.println( "Cats like to eat spiders and mice.");
    }
}
