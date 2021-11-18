package OPPPOLYMORPHISM;

interface Interfcae_truutuong1 {
	double getArea();
	double getPerimeter();
}
class Rectangle implements Interfcae_truutuong1{
	private double length;
	private double width;
	public Rectangle(double length, double width) {
		super();
		this.length = length;
		this.width = width;
	}
	@Override
	public double getArea() {
		return this.length*this.width;
	}
	@Override
	public double getPerimeter() {
		return (this.length+this.width)*2;
	}
}
class Circle implements Interfcae_truutuong1{
	private double radius;
	public Circle(double radius) {
		super();
		this.radius=radius;
	}
	@Override
	public double getArea() {
		return this.radius*this.radius*3.14;
	}
	public double getPerimeter() {
		return this.radius*2*3.14;
	}
}
