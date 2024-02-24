package PTIT.TET_HOLIDAY;
public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.setName("Micky");
        dog.setBreed("Husky");
        dog.setAge(12);
        System.out.println(String.format("Name:%s--Breed:%s--Age:%d", dog.getName(), dog.getBreed(), dog.getAge()));
    }
}
class Dog {
    private String name, breed;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

