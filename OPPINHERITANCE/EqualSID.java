package OPPINHERITANCE;

public class EqualSID {
	private String name;
	private int id;
	public EqualSID(String name, int id) {
		this.name=name;
		this.id=id;
	}
	/* 
	 * ghi de len phuong thuc equals cua Object
	 
	 */
	@Override
	public boolean equals(Object obj) {
		return this.id==((EqualSID)obj).id;
	}
	public static void main(String[]args) {
		EqualSID s1=new EqualSID("Dan", 17052002);
		EqualSID s2=new EqualSID("Dan", 17052002);
		System.out.println(s1.equals(s2));
	}
}
