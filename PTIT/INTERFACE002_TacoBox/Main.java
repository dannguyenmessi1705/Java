package PTIT.INTERFACE002_TacoBox;

public class Main {
    public static void main(String[] $) {
        TripleTacobox tT = new TripleTacobox();
        tT.eat();
        tT.eat();
        System.out.println(tT);

        CustomTacobox cT = new CustomTacobox(8);
        cT.eat();
        System.out.println(cT);
    }
}

interface TacoBox {
    public int tacoRemaining();
    public  void eat();
}
class TripleTacobox implements TacoBox {
    private int tacos;
    public TripleTacobox(){
        tacos = 3;
    }
    @Override
    public int tacoRemaining() {
        return tacos;
    }

    @Override
    public void eat() {
        if (tacos > 0) tacos--;
    }
    @Override
    public String toString(){
        return String.format("Triple taco boxes left: %d", tacos);
    }
}
class CustomTacobox implements TacoBox {
    private int tacos;
    public CustomTacobox(int initialTaco){
        this.tacos = initialTaco;
    }
    @Override
    public int tacoRemaining() {
        return tacos;
    }

    @Override
    public void eat() {
        if(tacos > 0) tacos--;
    }
    @Override
    public String toString(){
        return String.format("Custom taco boxes left: %d", tacos);
    }
}