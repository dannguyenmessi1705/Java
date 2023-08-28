package OPPPOLYMORPHISM;

abstract class Abstract {
	public abstract void soundAnimal();
	public void sleep() {
		System.out.println("Zzzz");
	}
}
class SupAbstract extends Abstract{
	public void soundAnimal() {
		System.out.println("bow wow");
	}
}
