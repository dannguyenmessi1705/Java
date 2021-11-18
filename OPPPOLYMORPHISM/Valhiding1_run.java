package OPPPOLYMORPHISM;

public class Valhiding1_run {
	public static void main(String[]args) {
		Valhiding1 a = new Supclass();
		System.out.println(a.x);
		System.out.println(((Supclass)a).x);
	}
}

