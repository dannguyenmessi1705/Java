package PTIT.ELAB2308_ClassCar;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());
        Car car;
        while (test-- > 0){
            String[] carInfo = sc.nextLine().split(" ");
            if(carInfo[0].equals("SC")){
                car = new SportCar(Double.parseDouble(carInfo[1]), Integer.parseInt(carInfo[2]));
            }else{
                car = new ClassicCar(Double.parseDouble(carInfo[1]), Integer.parseInt(carInfo[2]));
            }
            car.calculateSalePrice();
            System.out.println(car);
        }
        DecimalFormat df = new DecimalFormat("#,###,###.00");
        System.out.println("Most Expensive: " + df.format(Car.maxSalePrice) + " VND");
    }
}

abstract class Car{
    protected double price;
    protected int year;

    public static double maxSalePrice = 0;

    public Car(double price, int year){
        this.price = price;
        this.year = year;
    }
    public abstract double calculateSalePrice();

    public static void updateMaxSalePrice(double price){
        if(price > maxSalePrice){
            maxSalePrice = price;
        }
    }
    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("#,###,###.00");
        return "Price: " + df.format(price) + " VND | Year: " + year;
    }

}
class ClassicCar extends Car{
    private static final double TAX_RATE = 1.12;
    private static final double PLATE_FEE = 20000000;
    public ClassicCar(double price, int year) {
        super(price, year);
    }

    @Override
    public double calculateSalePrice(){
        price = price * TAX_RATE + PLATE_FEE;
        updateMaxSalePrice(price);
        return price;
    }


}
class SportCar extends Car{
    public static final double FEE_2018 = 0.8;
    public static final double FEE_2010 = 0.5;
    public static final double FEE_DEFAULT = 0.1;
    public SportCar(double price, int year) {
        super(price, year);
    }

    @Override
    public double calculateSalePrice(){
        double discount = 1;
        if (year > 2018) discount = FEE_2018;
        else if (year > 2010) discount = FEE_2010;
        else discount = FEE_DEFAULT;
        price = price * discount;
        updateMaxSalePrice(price);
        return price;
    }
}