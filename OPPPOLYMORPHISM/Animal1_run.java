package OPPPOLYMORPHISM;

class Animal1_run {
	public static void main(String[] args) {
		Animal1[] animals = new Animal1[4];
		animals[0]=new Animal1();
		animals[1]=new Dog1();
		animals[2]=new Cat1();
		animals[3]=new Duck1();
		for (int i = 0; i < 4; i++) {
			animals[i].sound();
		}
	}
}
