package PTIT.INTERFACE001_Interface_practice;

public class Main {
    public static void main(String[] $) {
        Book book1 = new Book("Fyodor Dostoevsky", "Crime and Punishment",2);
        Book book2 = new Book("Robert Martin", "Clean Code",1);
        Book book3 = new Book("Kent Beck", "Test Driven Development",0.5);
        CD cd1 = new CD("Pink Floyd", "Dark Side of the Moon", 1973);
        CD cd2 = new CD("Wigwam", "Nuclear Nightclub", 1975);
        CD cd3 = new CD("Rendezvous Park", "Closer to Being Here", 2012);
        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3);
        System.out.println(cd1);
        System.out.println(cd2);
        System.out.println(cd3);
    }
}

interface Package {
    double weight();
}
//Book: có constructor với các thuộc tính: author(String), name(String), weight(double)
//CD: có constructor với các thuộc tính : artist(String), name(String), publicationYear(int)
class Book implements Package{
    private String author;
    private String name;
    private double weight;

    public Book(String author, String name, double weight) {
        this.author = author;
        this.name = name;
        this.weight = weight;
    }

    @Override
    public double weight() {
        return weight;
    }
    @Override
    public String toString(){
        return String.format("%s: %s", author, name);
    }
}

class CD implements Package{
    private String artist;
    private String name;
    private int publicationYear;

    public CD(String artist, String name, int publicationYear) {
        this.artist = artist;
        this.name = name;
        this.publicationYear = publicationYear;
    }

    @Override
    public double weight() {
        return 0.1;
    }
    @Override
    public String toString(){
        return String.format("%s: %s (%d)", artist, name, publicationYear);
    }
}