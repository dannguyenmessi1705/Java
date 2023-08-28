package OPPPOLYMORPHISM;

class Animal1 {
	public void sound(){
		System.out.println("some sound");
	}
}

class Dog1 extends Animal1 {
	public void sound(){
		System.out.println("bow wow");
	}
}

class Cat1 extends Animal1 {
public void sound(){
		System.out.println("meow meow");
	}	
}

class Duck1 extends Animal1{
	public void sound(){
		System.out.println("quack quack");
	}
}
